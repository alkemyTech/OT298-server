package com.alkemy.ong.service;

import com.sendgrid.*;
import java.io.IOException;

import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendGridEmailService implements IEmailService {

    @Autowired
    private SendGrid sendGridClient;

    @Override
    public void sendWelcomeEmailTo(String to) {

    }

    @Override
    public void sendText(String from, String to, String subject, String body) throws IOException {
    }

    @Override
    public void sendHTML(String from, String to, String subject, String body) throws IOException {
    }

    private Response sendEmail(String from, String to, String subject, Content content) throws IOException {
        Mail mail = new Mail(new Email(from), subject, new Email(to), content);
        mail.setReplyTo(new Email(from));
        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());
        return this.sendGridClient.api(request);
    }
}
