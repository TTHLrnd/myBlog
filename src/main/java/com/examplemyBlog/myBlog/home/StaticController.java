package com.examplemyBlog.myBlog.home;

import com.examplemyBlog.myBlog.author.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class StaticController {

    private final AuthorService authorService;

    @GetMapping(value = {"/"})
    public String getLoginPage() {
        return "index";
    }

    @PostMapping(value = "/loginForm")
    public String login(@ModelAttribute("loginForm") LoginForm loginForm){
        return authorService.loginAuthor(loginForm);
    }

}
