package com.examplemyBlog.myBlog.author;

import com.examplemyBlog.myBlog.blog.Blog;
import com.examplemyBlog.myBlog.comment.Comment;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "authors",
        uniqueConstraints = {
                @UniqueConstraint(name = "author_unique_data", columnNames = {"email", "username"}
                )
        })
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Author implements UserDetails {
    @Id
    @SequenceGenerator(name = "authorId_seq", sequenceName = "authorId_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authorId_seq")
    @Column(name = "id",
            updatable = false)
    private Long id;
    @Column(
            name = "username",
            nullable = false
    )
    private String username;
    private String firstname;
    private String lastname;
    private LocalDate birthdate;
    @Column(
            name = "email",
            nullable = false
    )
    private String email;
    private String password;
    @OneToMany(mappedBy = "author")
    private List<Blog> userBlogs;
    @OneToMany(mappedBy = "author")
    private List<Comment> userComments;
    @CreationTimestamp
    private Timestamp regDate;
    @Enumerated(EnumType.STRING)
    private Role role;
    private Boolean locked = false;
    private Boolean enabled = false;

    public Author(String username,
                  String firstname,
                  String lastname,
                  LocalDate birthdate,
                  String email,
                  String password,
                  List<Blog> userBlogs,
                  List<Comment> userComments,
                  Role role) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.email = email;
        this.password = password;
        this.userBlogs = userBlogs;
        this.userComments = userComments;
        this.role = role;
    }

    public Author(String username,
                  String firstname,
                  String lastname,
                  LocalDate birthdate,
                  String email,
                  String password,
                  List<Blog> userBlogs,
                  List<Comment> userComments,
                  Role role,
                  Boolean locked,
                  Boolean enabled) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.email = email;
        this.password = password;
        this.userBlogs = userBlogs;
        this.userComments = userComments;
        this.role = role;
        this.locked = locked;
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.name());
        return Collections.singletonList(simpleGrantedAuthority);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String toString() {
        return "Author{" +
                "ID: " + getId() +
                "Firstname: " + getFirstname() +
                "Lastname: " + getLastname() +
                "Email: " + getEmail() +
                "Birthday: " + getBirthdate() +
                "Role: " + getRole().toString() + "}";
    }
}
