package com.mappy.subscriptionservice.services;

import com.mappy.subscriptionservice.models.Subscription;
import com.mappy.subscriptionservice.repositories.ISubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubscriptionService implements ISubscriptionService {
    private final ISubscriptionRepository subscriptionRepository;
    @Override
    public Subscription save(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Iterable<Subscription> getAll() {
        return subscriptionRepository.findAll();
    }

    @Override
    public Optional<Subscription> getById(int id) {
        return subscriptionRepository.findById(id);
    }

    @Override
    public Subscription update(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public void delete(Subscription subscription) {
        subscriptionRepository.delete(subscription);
    }

    @Override
    public Iterable<Subscription> getByAccountId(Long accountId) {
        return subscriptionRepository.findAllByAccountId(accountId);
    }
}
