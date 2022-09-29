package com.alkemy.ong.service;

import com.alkemy.ong.util.EmailConstants;
import com.sendgrid.*;

import java.io.IOException;

import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class SendGridEmailService implements IEmailService {
    @Value("${sendgrid.email}")
    private String sender;

    @Autowired
    private SendGrid sendGridClient;

    @Autowired
    private MessageSource messageSource;


    @Override
    public void sendText(String from, String to, String subject, String body) throws IOException {
    }

    @Override
    public void sendHTML(String from, String to, String subject, String body) throws IOException {
    }

    @Override
    public void sendWelcomeEmail(String email) throws IOException {
        Email from = new Email(sender);
        Email to = new Email(email);
        String subject = EmailConstants.SUBJECT_WELCOME;
        Content content = new Content("text/html", EmailConstants.TEMPLATE_WELCOME);
        Mail mail = new Mail(from, subject, to, content);
        sendMail(mail);
    }

    public void sendMail(Mail mail) throws IOException{
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint(EmailConstants.ENDPOINT);
            request.setBody(mail.build());
            sendGridClient.api(request);
        } catch (IOException ex) {
            throw new IOException(messageSource.getMessage("email.not.sent",null, Locale.US));
        }
    }
}
