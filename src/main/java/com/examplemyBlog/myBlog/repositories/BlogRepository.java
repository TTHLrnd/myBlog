package com.examplemyBlog.myBlog.repositories;

import com.examplemyBlog.myBlog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {


}
