package com.examplemyBlog.myBlog.home;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class HomePageController {

    @GetMapping(value = {"/homepage"})
    public String getHomePage() {
        return "homepage";
    }
}
