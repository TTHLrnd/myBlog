package com.examplemyBlog.myBlog.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="blogs")
@Getter
@Setter
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Blog.findAll", query = "SELECT b FROM Blog b")
})
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blog_generator")
    @SequenceGenerator(name="blogId_seq", sequenceName = "blogId_seq", allocationSize=1)
    private Long id;
    private String title;
    private Category category;
    private String content;
    @ManyToOne
    private Author author;
    @OneToMany(mappedBy = "blog")
    private List<Comment> comments;
    @ManyToOne
    private Template template;

    public Blog(String title, Category category, String content, Template template) {
        this.title = title;
        this.category = category;
        this.content = content;
        this.template = template;
    }
}


