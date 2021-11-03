package com.examplemyBlog.myBlog.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HomePageController {

    @GetMapping(value = {"/homepage"})
    public String getHomePage() {
        return "homepage";
    }
}
