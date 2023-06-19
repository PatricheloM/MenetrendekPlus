package hu.menetrendekplus.backend.converter;

import hu.menetrendekplus.backend.dto.response.FareDto;
import hu.menetrendekplus.backend.dto.response.LineDto;
import hu.menetrendekplus.backend.dto.response.RouteDto;
import hu.menetrendekplus.backend.model.response.Route;

import java.util.stream.Collectors;

public class RouteConverter {

    public RouteDto convert(Route route) {

        return new RouteDto(
                route.getIndulasi_hely(),
                route.getErkezesi_hely(),
                route.getIndulasi_ido(),
                route.getErkezesi_ido(),
                route.getAtszallasok_szama(),
                route.getOsszido(),
                route.getExplanations(),
                route.getTotalDistance(),
                new FareDto(route.getTotalFare(), route.getTotalFare50(), route.getTotalFare90()),
                route.getJaratinfok().keySet().stream().map(k ->
                        new LineDto(
                                route.getJaratinfok().get(k).getVonalnev(),
                                route.getAtszallasinfok().get(k).getAtszallohely(),
                                route.getNativeData().get(Integer.parseInt(k)).getOwnerName(),
                                route.getNativeData().get(Integer.parseInt(k)).getDomain_code()))
                        .collect(Collectors.toUnmodifiableList())
                );
    }
}
