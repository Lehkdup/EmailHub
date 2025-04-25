package com.email.controller;

import com.email.payload.EmailPayload;
import com.email.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {

  private final EmailService emailService;

  public EmailController(EmailService emailService) {
    this.emailService = emailService;
  }

  @PostMapping("/send")
  public ResponseEntity<String> sendEmail(@RequestBody EmailPayload payload)
      throws MessagingException {
    emailService.sendFormattedEmail(payload);
    return ResponseEntity.ok("Email sent successfully");
  }
}
