package hu.menetrendekplus.backend.converter;

import hu.menetrendekplus.backend.dto.response.StationDto;
import hu.menetrendekplus.backend.model.response.Station;

public class SimpleStationConverter {

    public String convert(Station station) {
        return station.getLsname();
    }

    public String convert(StationDto stationDto) {
        return stationDto.getStationName();
    }
}
