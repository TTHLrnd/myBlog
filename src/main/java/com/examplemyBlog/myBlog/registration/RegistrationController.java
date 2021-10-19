package com.examplemyBlog.myBlog.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/register")
    public String register(@ModelAttribute("register") RegistrationRequest register) {
        return registrationService.register(register);
    }

    @GetMapping(path = "/blog/registration/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
