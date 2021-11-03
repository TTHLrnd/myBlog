package com.examplemyBlog.myBlog.repositories;

import com.examplemyBlog.myBlog.model.Template;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TemplateRepo extends JpaRepository<Template, Long> {

    Optional<Template> findById(Long id);
}
