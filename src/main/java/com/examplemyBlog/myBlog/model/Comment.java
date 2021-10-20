package com.examplemyBlog.myBlog.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_generator")
    @SequenceGenerator(name="commentId_seq", sequenceName = "commentId_seq", allocationSize=1)
    private long id;
    private Timestamp pubDate;
    @ManyToOne
    private Blog blog;
    @ManyToOne
    private Author author;
    private String string;
    private boolean isReply;
    @OneToOne
    private Comment repliedTo;
}
