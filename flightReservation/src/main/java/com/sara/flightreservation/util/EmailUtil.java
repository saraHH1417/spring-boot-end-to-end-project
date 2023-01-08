package com.sara.flightreservation.util;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class EmailUtil {
    private JavaMailSender sender;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);

    public void sendItinerary(String toAddress, String filePath) {
        LOGGER.info("Inside sendItinerary()");
        MimeMessage message = sender.createMimeMessage();
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setTo(toAddress);
            messageHelper.setSubject("Itinerary for your Flight");
            messageHelper.setText("Please find your Itinerary here");
            messageHelper.addAttachment("Itinerary", new File(filePath));
            sender.send(message);
        } catch (MessagingException e) {
            LOGGER.error("Exception inside sendItinerary" + e);
        }


    }
}
