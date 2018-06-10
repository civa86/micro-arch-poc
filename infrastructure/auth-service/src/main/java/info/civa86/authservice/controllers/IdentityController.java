package info.civa86.authservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;
import org.springframework.security.core.Authentication;
import info.civa86.authservice.model.CustomUserDetails;

@RestController
public class IdentityController {

    @GetMapping(value = "/me")
    public CustomUserDetails user(Principal principal) {
        return (CustomUserDetails) ((Authentication) principal).getPrincipal();
    }
}