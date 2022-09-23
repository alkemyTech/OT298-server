package com.alkemy.ong.service.Impl;

import com.alkemy.ong.service.IEmailService;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;


public class EmailServiceImpl implements IEmailService {

    @Autowired
    private Environment env;
    @Value("${ong.email.sender}")
    private String emailSender;

    @Override
    public void sendWelcomeEmailTo(String to) {

        String apiKey = env.getProperty("EMAIL_API_KEY");

        Email fromEmail = new Email(emailSender);
        Email toEmail = new Email(to);
        Content content = new Content(
                "text/html",
                "msj.html"
        );

    }

}
