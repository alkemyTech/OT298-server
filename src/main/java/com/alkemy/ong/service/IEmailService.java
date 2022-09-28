package com.alkemy.ong.service;

import java.io.IOException;

public interface IEmailService {


    void sendWelcomeEmailTo(String to) throws IOException;
    void sendText(String from, String to, String subject, String body) throws IOException;
    void sendHTML(String from, String to, String subject, String body) throws IOException;
    
}

