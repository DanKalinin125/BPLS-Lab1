package com.example.bplslab1.service;

import com.example.bplslab1.Utils;
import com.example.bplslab1.entity.Subscription;
import com.example.bplslab1.repository.SubscriptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    public Subscription subscribe(String email) throws Exception {
        Optional<Subscription> optionalSubscription = subscriptionRepository.findByEmail(email);

        if (optionalSubscription.isPresent()) throw new Exception("Вы уже подписаны на новости");

        return subscriptionRepository.save(Subscription.builder()
                .email(email)
                .creationDateTime(Utils.getCurrentDateTime())
                .build());
    }
}
