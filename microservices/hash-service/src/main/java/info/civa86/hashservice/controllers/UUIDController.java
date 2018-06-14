package info.civa86.hashservice.controllers;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import info.civa86.hashservice.models.UUIDModel;

@RestController
@ResponseBody
public class UUIDController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UUIDController.class);

    @GetMapping(path = "/uuid")
    public UUIDModel getUUID() {
        String generatedUUID = UUID.randomUUID().toString();
        LOGGER.info("Generated UUID - {}", generatedUUID);
        return new UUIDModel(generatedUUID);
    }
}