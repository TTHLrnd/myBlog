package com.examplemyBlog.myBlog.forms;

import com.examplemyBlog.myBlog.model.Category;
import com.examplemyBlog.myBlog.model.Template;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class BlogCreationRequest {
    private String title;
    private Category category;
    private String content;
    private Long templateId;
}
