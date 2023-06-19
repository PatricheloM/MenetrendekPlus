package hu.menetrendekplus.backend.converter;

import hu.menetrendekplus.backend.dto.response.StationDto;
import hu.menetrendekplus.backend.model.response.Station;

public class StationConverter {

    public StationDto convert(Station station) {
        return new StationDto(station.getLsname(), station.getSettlement_id(), station.getLs_id());
    }
}
