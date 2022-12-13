package com.yal.pushnotifications.controller;


import com.google.firebase.messaging.FirebaseMessagingException;
import com.yal.pushnotifications.dto.Note;
import com.yal.pushnotifications.service.FirebaseMessagingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirebaseController {
    private FirebaseMessagingService firebaseMessagingService;
    @PostMapping("/send-notification")
    public String sendNotification(@RequestBody Note note, @RequestParam String token) throws FirebaseMessagingException {
        return firebaseMessagingService.sendNotification(note, token);
    }
}
