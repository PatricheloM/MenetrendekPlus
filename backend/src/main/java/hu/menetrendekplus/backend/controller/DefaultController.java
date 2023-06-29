package hu.menetrendekplus.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import hu.menetrendekplus.backend.dto.request.QueryRoutesDto;
import hu.menetrendekplus.backend.dto.request.QueryStationsDto;
import hu.menetrendekplus.backend.dto.response.StationDto;
import hu.menetrendekplus.backend.service.DefaultService;
import hu.menetrendekplus.backend.util.JsonValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class DefaultController {

    @Autowired
    private DefaultService service;

    @Autowired
    private ModelMapper mapper;

    @PostMapping(value = "/queryStations", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<?> queryStations(@RequestBody Object object) throws IOException, URISyntaxException, InterruptedException {
        try {
            if (JsonValidator.validate(object, QueryStationsDto.class)) {
                QueryStationsDto dto = mapper.map(object, QueryStationsDto.class);
                if (dto.isSimple()) {
                    return new ResponseEntity<>(service.getSimpleStations(dto), HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(service.getStations(dto), HttpStatus.OK);
                }
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }  catch (JsonValidator.SchemaNotFoundException | JsonProcessingException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/queryRoutes", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<?> queryRoutes(@RequestBody Object object) throws IOException, URISyntaxException, InterruptedException {
        try {
            if (JsonValidator.validate(object, QueryRoutesDto.class)) {
                return new ResponseEntity<>(service.getRoutes(mapper.map(object, QueryRoutesDto.class)), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (JsonValidator.SchemaNotFoundException | JsonProcessingException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "station/{stationName}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<?> getStation(@PathVariable("stationName") String stationName)  throws IOException, URISyntaxException, InterruptedException {
        Optional<StationDto> s = service.getSingleStation(stationName);
        if (s.isPresent()) {
            return new ResponseEntity<>(s.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
