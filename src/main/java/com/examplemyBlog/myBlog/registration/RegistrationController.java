package com.examplemyBlog.myBlog.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/register")
    public RedirectView register(@ModelAttribute("register") RegistrationRequest register) {
        return new RedirectView(registrationService.register(register));
    }

    @GetMapping(path = "/blog/registration/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
