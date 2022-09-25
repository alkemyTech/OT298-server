package com.alkemy.ong.service.Impl;

import com.alkemy.ong.service.IEmailService;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;

public class EmailServiceImpl implements IEmailService {

    @Value("${ong.email.sender}")
    private String emailSender;

    private static final String API_KEY = "EMAIL_API_KEY";

    @Override
    public void sendWelcomeEmailTo(String to) {

        Email fromEmail = new Email(emailSender);
        Email toEmail = new Email(to);
        Content content = new Content(
                "text/html",
                "msj.html"

        );

    }

}
