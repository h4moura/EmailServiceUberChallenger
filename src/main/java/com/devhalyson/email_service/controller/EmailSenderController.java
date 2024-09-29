package com.devhalyson.email_service.controller;

import com.devhalyson.email_service.application.EmailSenderService;
import com.devhalyson.email_service.core.EmailRequest;
import com.devhalyson.email_service.core.exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailSenderController {
    private final EmailSenderService emailSenderService;

    @Autowired
    public EmailSenderController(EmailSenderService emailSenderService){
        this.emailSenderService = emailService;
    }

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request){
        try{
            this.emailSenderService.sendEmail(request.to(), request.subject(), requst.body());
            return ResponseEntity.ok("email send successfully");
        } catch(EmailServiceException ex){
            return ResponseEntity.stutus(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while sending email");
        }
    }
}
