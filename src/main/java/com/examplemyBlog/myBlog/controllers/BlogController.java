package com.examplemyBlog.myBlog.controllers;

import com.examplemyBlog.myBlog.forms.BlogCreationRequest;
import com.examplemyBlog.myBlog.model.Blog;
import com.examplemyBlog.myBlog.services.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/blogs")
public class BlogController {

    private final BlogService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Blog> getBlogs(){
        return service.getBlogs();
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.POST)
    public String createBlog(@ModelAttribute("blogRequest") BlogCreationRequest request){
        service.createBlog(request);
        return "blog created";
    }
}
