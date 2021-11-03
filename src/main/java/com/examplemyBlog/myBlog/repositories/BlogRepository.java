package com.examplemyBlog.myBlog.repositories;

import com.examplemyBlog.myBlog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
}
