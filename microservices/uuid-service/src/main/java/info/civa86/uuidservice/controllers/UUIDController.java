package info.civa86.uuidservice.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.UUID;
import info.civa86.uuidservice.models.UUIDModel;

@RestController
@ResponseBody
public class UUIDController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UUIDController.class);

    @GetMapping(path = "/")
    public UUIDModel getUUID() {
        String generatedUUID = UUID.randomUUID().toString();
        LOGGER.info("Generated UUID - {}", generatedUUID);
        return new UUIDModel(generatedUUID);
    }
}