package com.email.service;

import com.email.payload.EmailPayload;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

  private final JavaMailSender emailSender;
  private final TemplateEngine templateEngine;
  //@Value("${spring.mail.username}")
  //private String fromEmail;
  @Async
  public void sendFormattedEmail(EmailPayload request) throws MessagingException {
    Context context = new Context();
    context.setVariable("emailRequest", request);

    String body = templateEngine.process("email_template", context);

    MimeMessage mimeMessage = getMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

    try {
      helper.setTo(request.getEmail());
      helper.setSubject("Ihre Reiseübersicht");
      helper.setText(body, true);
      emailSender.send(mimeMessage);
    } catch (MessagingException e) {
      log.warn(e.getMessage());
    }
  }
  private MimeMessage getMimeMessage() {
    return emailSender.createMimeMessage();
  }

}
