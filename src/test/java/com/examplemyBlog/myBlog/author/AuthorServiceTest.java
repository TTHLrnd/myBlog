package com.examplemyBlog.myBlog.author;

import com.examplemyBlog.myBlog.home.LoginForm;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

@Transactional
@ExtendWith(SpringExtension.class)
@SpringBootTest
class AuthorServiceTest {


    private final AuthorService authorService;
    @Autowired
    public AuthorServiceTest(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Test
    void loginAuthorTest() {
        LoginForm loginFormTest_correct = new LoginForm(
                "lorandtoth.lori@gmail.com",
                "admin"
        );

        Assertions.assertEquals("homepage", authorService.loginAuthor(loginFormTest_correct));
    }
}