package com.examplemyBlog.myBlog.repositories;

public interface EmailSender {
    void send(String to, String email);
}
