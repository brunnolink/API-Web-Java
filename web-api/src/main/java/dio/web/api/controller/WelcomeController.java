package dio.web.api.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping
    public String welcome(){
        return "Welcome to My Spring Boot Web API";
    }
    @GetMapping("/welcome/users")
    public String users() {
        return "Authorized user";
    }
    @GetMapping("/welcome/managers")
    public String managers() {
        return "Authorized manager";
    }
}