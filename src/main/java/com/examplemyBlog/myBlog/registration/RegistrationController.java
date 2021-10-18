package com.examplemyBlog.myBlog.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/register")
    public String register(@ModelAttribute("register") RegistrationRequest register){
        return registrationService.register(register);
    }

    @GetMapping(path = "/blog/registration/confirm")
    public String confirm(@RequestParam("token") String token){
        return registrationService.confirmToken(token);
    }

/*    @Bean
    CommandLineRunner commandLineRunnerAdmin(AuthorRepository authorRepository) {
        return args -> {
            registrationService.registerAdmin(new RegistrationRequest(
                    "admin",
                    "admin",
                    "admin",
                    "1999",
                    "2",
                    "12",
                    "lorandtoth.lori@gmail.com",
                    "admin"
            ));
        };
    }*/
}
