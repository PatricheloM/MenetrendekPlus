package hu.menetrendekplus.backend.service;

import hu.menetrendekplus.backend.converter.RouteConverter;
import hu.menetrendekplus.backend.converter.SimpleStationConverter;
import hu.menetrendekplus.backend.converter.StationConverter;
import hu.menetrendekplus.backend.dto.request.QueryRoutesDto;
import hu.menetrendekplus.backend.dto.request.QueryStationsDto;
import hu.menetrendekplus.backend.dto.response.RouteDto;
import hu.menetrendekplus.backend.dto.response.StationDto;
import hu.menetrendekplus.backend.model.request.FunctionType;
import hu.menetrendekplus.backend.model.request.GetRoutes;
import hu.menetrendekplus.backend.model.request.GetStations;
import hu.menetrendekplus.backend.model.request.MenetrendekRequest;
import hu.menetrendekplus.backend.model.response.RoutesResult;
import hu.menetrendekplus.backend.model.response.Station;
import hu.menetrendekplus.backend.util.MenetrendekHttpRequestHandler;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DefaultService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private MenetrendekHttpRequestHandler handler;

    @Autowired
    private StationConverter stationConverter;

    @Autowired
    private SimpleStationConverter simpleStationConverter;

    @Autowired
    private RouteConverter routeConverter;

    protected List<Station> getStationsBase(QueryStationsDto dto) throws IOException, URISyntaxException, InterruptedException {

        MenetrendekRequest<GetStations> body = new MenetrendekRequest<>();

        GetStations params = new GetStations();
        params.setInputText(dto.getQuery());
        params.setMaxResults(dto.getMaxResults());

        body.setFunc(FunctionType.GET_STATION.funcName);
        body.setParams(params);

        return ((List<?>) handler.sendRequest(body).getResults()).stream()
                .map(s -> mapper.map(s, Station.class)).collect(Collectors.toUnmodifiableList());
    }

    public List<StationDto> getStations(QueryStationsDto dto) throws IOException, URISyntaxException, InterruptedException {
        return getStationsBase(dto).stream()
                .map(s -> stationConverter.convert(s)).collect(Collectors.toUnmodifiableList());
    }

    public List<String> getSimpleStations(QueryStationsDto dto) throws IOException, URISyntaxException, InterruptedException {
        return getStationsBase(dto).stream()
                .map(s -> simpleStationConverter.convert(s)).collect(Collectors.toUnmodifiableList());
    }

    public Optional<StationDto> getSingleStation(String stationName) throws IOException, URISyntaxException, InterruptedException {
        return getStationsBase(new QueryStationsDto(stationName, 1)).stream()
                .map(s -> stationConverter.convert(s)).findFirst();
    }

    public List<RouteDto> getRoutes(QueryRoutesDto dto) throws IOException, URISyntaxException, InterruptedException {

        MenetrendekRequest<GetRoutes> body = new MenetrendekRequest<>();

        Optional<StationDto> starting = getSingleStation(dto.getStartingStation());
        Optional<StationDto> arriving = getSingleStation(dto.getArrivingStation());

        if (starting.isEmpty() || arriving.isEmpty()) {
            return Collections.emptyList();
        }

        GetRoutes params = new GetRoutes();

        params.setHonnan(starting.get().getStationName());
        params.setHonnan_ls_id(starting.get().getStationId());
        params.setHonnan_settlement_id(starting.get().getSettlementId());
        params.setHova(arriving.get().getStationName());
        params.setHova_ls_id(arriving.get().getStationId());
        params.setHova_settlement_id(arriving.get().getSettlementId());

        params.setDatum(dto.getDate());
        params.setHour(dto.getHour());
        params.setMin(dto.getMin());

        params.setMaxatszallas(dto.getMaxChanges());
        params.setMaxwalk(dto.getMaxWalk());

        body.setFunc(FunctionType.GET_ROUTES.funcName);
        body.setParams(params);


        return mapper.map(handler.sendRequest(body).getResults(), RoutesResult.class).getTalalatok().values()
                .stream().map(r -> routeConverter.convert(r)).collect(Collectors.toUnmodifiableList());
    }
}
