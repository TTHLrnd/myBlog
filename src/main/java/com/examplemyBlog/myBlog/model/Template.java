package com.examplemyBlog.myBlog.model;


import javax.persistence.*;

@Entity
@Table(name = "templates")
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "template_generator")
    @SequenceGenerator(name="template_seq", sequenceName = "templateId_seq", allocationSize=1)
    private long id;
    private String template;
}
