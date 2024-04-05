package com.example.bplslab1.service;

import com.example.bplslab1.Utils;
import com.example.bplslab1.entity.Subscription;
import com.example.bplslab1.repository.SubscriptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    public Subscription subscribe(String email) throws Exception {
        try {
            return subscriptionRepository.save(Subscription.builder()
                    .email(email)
                    .creationDateTime(Utils.getCurrentDateTime())
                    .build());
        } catch (Exception exception) {
            throw new Exception("Вы уже подписаны на новости");
        }
    }
}
