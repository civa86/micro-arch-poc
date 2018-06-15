package info.civa86.hashservice.controllers;

import java.util.HashMap;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class UUIDController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UUIDController.class);

    @GetMapping(path = "/uuid")
    public HashMap<String, String> getUUID() {
        HashMap<String, String> result = new HashMap<String, String>();
        String generatedUUID = UUID.randomUUID().toString();

        result.put("uuid", generatedUUID);

        LOGGER.info("Generated UUID - {}", generatedUUID);

        return result;
    }
}