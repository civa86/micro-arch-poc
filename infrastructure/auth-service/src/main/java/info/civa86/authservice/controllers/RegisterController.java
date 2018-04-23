package info.civa86.authservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @GetMapping(value = "/register")
    public String index() {
        return "Hello world";
    }
}