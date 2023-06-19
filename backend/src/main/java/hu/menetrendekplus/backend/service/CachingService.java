package hu.menetrendekplus.backend.service;

import com.ethlo.time.DateTime;
import com.ethlo.time.TimezoneOffset;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hu.menetrendekplus.backend.dto.request.QueryRoutesDto;
import hu.menetrendekplus.backend.dto.response.RouteDto;
import hu.menetrendekplus.backend.dto.response.StationDto;
import hu.menetrendekplus.backend.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CachingService {

    @Autowired
    private RedisRepository repository;

    private final ObjectMapper mapper = new ObjectMapper();

    private final int ONE_HOUR_IN_SEC = 3600;

    private final int STATION_EXPIRATION = 8 * ONE_HOUR_IN_SEC;
    private final int ROUTES_QUERY_EXPIRATION = 24 * ONE_HOUR_IN_SEC;

    public void cacheStation(StationDto dto) throws JsonProcessingException {
        repository.setex(dto.getStationName(), mapper.writeValueAsString(dto), STATION_EXPIRATION);
    }

    public boolean isStationInCache(String stationName) {
        return repository.exists(stationName);
    }

    public Optional<StationDto> getStationFromCache(String stationName) throws JsonProcessingException{
        if (isStationInCache(stationName)) {
            repository.expire(stationName, STATION_EXPIRATION);
            return Optional.of(mapper.readValue(repository.get(stationName), StationDto.class));
        }
        return Optional.empty();
    }

    public void cacheRoutesQuery(QueryRoutesDto dto, List<RouteDto> response) throws JsonProcessingException {
        List<Integer> date = Arrays.stream(dto.getDate().split("-")).map(Integer::parseInt).collect(Collectors.toUnmodifiableList());

        long qEpoch = LocalDateTime.of(date.get(0), date.get(1), date.get(2), dto.getHour(), dto.getMin()).toEpochSecond(ZoneOffset.UTC);
        long cEpoch = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);

        int diff = Math.toIntExact(qEpoch - cEpoch);

        if (diff > 0) {
            repository.setex(mapper.writeValueAsString(dto), mapper.writeValueAsString(response), diff + ROUTES_QUERY_EXPIRATION);
        }
    }

    public boolean isRoutesQueryInCache(QueryRoutesDto dto) throws JsonProcessingException {
        return repository.exists(mapper.writeValueAsString(dto));
    }

    public List<RouteDto> getRoutesQueryFromCache(QueryRoutesDto dto) throws JsonProcessingException {
        return mapper.readValue(repository.get(mapper.writeValueAsString(dto)), new TypeReference<>() {});
    }
}
