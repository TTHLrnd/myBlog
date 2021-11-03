package com.examplemyBlog.myBlog.services;

import com.examplemyBlog.myBlog.forms.BlogCreationRequest;
import com.examplemyBlog.myBlog.model.Blog;
import com.examplemyBlog.myBlog.model.Template;
import com.examplemyBlog.myBlog.repositories.BlogRepository;
import com.examplemyBlog.myBlog.repositories.TemplateRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final TemplateRepo templateRepo;

    public List<Blog> getBlogs(){
        return blogRepository.findAll();
    }

    public String createBlog(BlogCreationRequest request){
        blogRepository.save(new Blog(
                request.getTitle(),
                request.getCategory(),
                request.getContent(),
                templateRepo.findById(request.getTemplateId()).get()
        ));
        return "blog";
    }


}
