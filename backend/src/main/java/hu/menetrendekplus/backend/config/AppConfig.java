package hu.menetrendekplus.backend.config;

import hu.menetrendekplus.backend.converter.RouteConverter;
import hu.menetrendekplus.backend.converter.SimpleStationConverter;
import hu.menetrendekplus.backend.converter.StationConverter;
import hu.menetrendekplus.backend.util.MenetrendekHttpRequestHandler;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    MenetrendekHttpRequestHandler httpRequestHandler() {
        return new MenetrendekHttpRequestHandler();
    }

    @Bean
    StationConverter stationsConverter() {
        return new StationConverter();
    }

    @Bean
    SimpleStationConverter simpleStationsConverter() {
        return new SimpleStationConverter();
    }

    @Bean
    RouteConverter routeConverter() {
        return new RouteConverter();
    }
}
