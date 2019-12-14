package net.celestialdata.api;

import net.celestialdata.States;
import net.celestialdata.model.ArrayOfStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-24T00:01:04.004Z[GMT]")
@Controller
public class StatusApiController implements StatusApi {

    private static final Logger log = LoggerFactory.getLogger(StatusApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public StatusApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ArrayOfStatus> getStatus() {
        try {
            return new ResponseEntity<ArrayOfStatus>(objectMapper.readValue(
                    "[ " +
                            "{\n  \"name\" : \"Play Structure\",\n  \"running\" : " + States.isPlayStructureOn() + "\n}, " +
                            "{\n  \"name\" : \"Lazy River\",\n  \"running\" : " + States.isLazyRiverOn() + "\n}, " +
                            "{\n  \"name\" : \"River Fountains\",\n  \"running\" : " + States.isRiverFountainsOn() + "\n}, " +
                            "{\n  \"name\" : \"Center Jets\",\n  \"running\" : " + States.isCenterJetsOn() + "\n}, " +
                            "{\n  \"name\" : \"Yellow Slide\",\n  \"running\" : " + States.isYellowSlideOn() + "\n}, " +
                            "{\n  \"name\" : \"Blue Slide\",\n  \"running\" : " + States.isBlueSlideOn() + "\n}, " +
                            "{\n  \"name\" : \"Emergency Stop\",\n  \"running\" : " + States.isEmergencyStopOn() + "\n} " +
                            "]",
                    ArrayOfStatus.class), HttpStatus.OK);
        } catch (IOException e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<ArrayOfStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}