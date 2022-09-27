package com.alkemy.ong.service;

public interface IEmailService {


    void sendWelcomeEmailTo(String to);
    void sendText(String from, String to, String subject, String body);
    void sendHTML(String from, String to, String subject, String body);
    
}

