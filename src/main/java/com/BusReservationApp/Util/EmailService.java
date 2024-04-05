package com.BusReservationApp.Util;

import javax.activation.DataSource;
import javax.mail.util.ByteArrayDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.internet.MimeMessage;


@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendEmailWithAttachment(String to, byte[] attachment, String subject, String text,String attachmentName) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);

            DataSource dataSource=new ByteArrayDataSource(attachment,"application/pdf");
            helper.addAttachment(attachmentName,dataSource);

            emailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

