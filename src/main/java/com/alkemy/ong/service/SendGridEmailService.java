package com.alkemy.ong.service;

import com.sendgrid.*;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendGridEmailService implements EmailService {

    @Autowired
    private SendGrid sendGridClient;

    @Override
    public Response sendText(String from, String to, String subject, String body) throws IOException {
        return sendEmail(from, to, subject, new Content("text/plain", body));
    }

    @Override
    public Response sendHTML(String from, String to, String subject, String body) throws IOException {
        return sendEmail(from, to, subject, new Content("text/html", body));
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
