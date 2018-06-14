package info.civa86.authservice.controllers;

import java.security.Principal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import info.civa86.authservice.exceptions.EmailAlreadyPresentException;
import info.civa86.authservice.model.CustomUserDetails;
import info.civa86.authservice.model.Role;
import info.civa86.authservice.model.Users;
import info.civa86.authservice.service.CustomUserDetailsService;
import info.civa86.authservice.service.RoleService;

@RestController
public class UserController {

    @Autowired
    private CustomUserDetailsService userService;
    @Autowired
    private RoleService roleService;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping(value = "/user")
    public CustomUserDetails getUser(Principal principal) {
        return (CustomUserDetails) ((Authentication) principal).getPrincipal();
    }

    @PostMapping(value = "/user")
    @ResponseStatus(HttpStatus.CREATED)
    public Users createUser(@RequestBody @Valid Users user) throws EmailAlreadyPresentException {
        if (this.userService.isEmailAlreadyRegistered(user.getEmail()) == true) {
            throw new EmailAlreadyPresentException();
        }

        Users newUser = new Users();
        Set<Role> roles = new HashSet<Role>();

        Role role = roleService.findRoleById(1);
        if (role != null) {
            roles.add(role);
        }

        newUser.setEmail(user.getEmail());
        newUser.setPassword(this.passwordEncoder.encode(user.getPassword()));
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setActive(1);
        newUser.setRoles(roles);

        this.userService.saveUser(newUser);

        return newUser;
    }

    @GetMapping(value = "/crypt")
    public HashMap<String, String> cryptString(@RequestParam(value = "string", required = true) String str) {
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("decoded", str);
        result.put("encoded", this.passwordEncoder.encode(str));
        return result;
    }
}