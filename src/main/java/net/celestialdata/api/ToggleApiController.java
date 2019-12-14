package net.celestialdata.api;

import net.celestialdata.States;
import net.celestialdata.model.FeatureStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-24T00:01:04.004Z[GMT]")
@Controller
public class ToggleApiController implements ToggleApi {

    private static final Logger log = LoggerFactory.getLogger(ToggleApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ToggleApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<FeatureStatus> toggleFeature(@NotNull @ApiParam(value = "The name of the water feature to toggle.", required = true) @Valid @RequestParam(value = "name", required = true) String name) {
        switch(name) {
            case "Play Structure":
                States.togglePlayStructure();
                try {
                    return new ResponseEntity<FeatureStatus>(objectMapper.readValue("{\n  \"running\" : " + States.isPlayStructureOn() + ",\n  \"name\" : \"Play Structure\"\n}", FeatureStatus.class), HttpStatus.OK);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<FeatureStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            case "Lazy River":
                States.toggleLazyRiver();
                try {
                    return new ResponseEntity<FeatureStatus>(objectMapper.readValue("{\n  \"running\" : " + States.isLazyRiverOn() + ",\n  \"name\" : \"Lazy River\"\n}", FeatureStatus.class), HttpStatus.OK);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<FeatureStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            case "River Fountains":
                States.toggleRiverFountains();
                try {
                    return new ResponseEntity<FeatureStatus>(objectMapper.readValue("{\n  \"running\" : " + States.isRiverFountainsOn() + ",\n  \"name\" : \"River Fountains\"\n}", FeatureStatus.class), HttpStatus.OK);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<FeatureStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            case "Center Jets":
                States.toggleCenterJets();
                try {
                    return new ResponseEntity<FeatureStatus>(objectMapper.readValue("{\n  \"running\" : " + States.isCenterJetsOn() + ",\n  \"name\" : \"Center Jets\"\n}", FeatureStatus.class), HttpStatus.OK);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<FeatureStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            case "Yellow Slide":
                States.toggleYellowSlide();
                try {
                    return new ResponseEntity<FeatureStatus>(objectMapper.readValue("{\n  \"running\" : " + States.isYellowSlideOn() + ",\n  \"name\" : \"Yellow Slide\"\n}", FeatureStatus.class), HttpStatus.OK);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<FeatureStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            case "Blue Slide":
                States.toggleBlueSlide();
                try {
                    return new ResponseEntity<FeatureStatus>(objectMapper.readValue("{\n  \"running\" : " + States.isBlueSlideOn() + ",\n  \"name\" : \"Blue Slide\"\n}", FeatureStatus.class), HttpStatus.OK);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<FeatureStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            case "Emergency Stop":
                States.toggleEmergencyStop();
                try {
                    return new ResponseEntity<FeatureStatus>(objectMapper.readValue("{\n  \"running\" : " + States.isEmergencyStopOn() + ",\n  \"name\" : \"Emergency Stop\"\n}", FeatureStatus.class), HttpStatus.OK);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<FeatureStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
        }

        return new ResponseEntity<FeatureStatus>(HttpStatus.BAD_REQUEST);
    }

}
