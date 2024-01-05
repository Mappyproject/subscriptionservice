package com.mappy.subscriptionservice.services;

import com.mappy.subscriptionservice.models.Feed;
import com.mappy.subscriptionservice.models.Subscription;

import java.util.Optional;

public interface ISubscriptionService {
    Subscription save(Subscription subscription);
    Iterable<Subscription> getAll();
    Optional<Subscription> getById(Long id);
    Subscription update(Subscription subscription);
    void delete(Subscription subscription);
    Iterable<Subscription> getByAccountId(Long accountId);
}
