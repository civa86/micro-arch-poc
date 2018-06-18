package info.civa86.hashservice.controllers;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@ResponseBody
public class BCryptController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BCryptController.class);

    @GetMapping(value = "/bcrypt")
    public HashMap<String, String> cryptString(@RequestParam(value = "string", required = true) String str) {
        HashMap<String, String> result = new HashMap<String, String>();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedStr = passwordEncoder.encode(str);

        result.put("decoded", str);
        result.put("encoded", encodedStr);

        LOGGER.info("BCrypt - original: {}, encoded: {}", str, encodedStr);

        return result;
    }
}