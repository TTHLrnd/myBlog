package com.examplemyBlog.myBlog.forms;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String email;
    private final String firstname;
    private final String lastname;
    private final String birthYear;
    private final String birthMonth;
    private final String birthDay;
    private final String username;
    private final String password;
}
