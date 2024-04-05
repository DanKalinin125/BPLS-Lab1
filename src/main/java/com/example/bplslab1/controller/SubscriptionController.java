package com.example.bplslab1.controller;

import com.example.bplslab1.service.SubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/subscribe")
@AllArgsConstructor
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<?> subscribe(String email) {
        if (email == null || email.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Отсутствуют обязательные параметры");

        try {
            return new ResponseEntity<>(subscriptionService.subscribe(email), HttpStatus.OK);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.LOCKED).body(exception.getLocalizedMessage());
        }
    }
}
