package com.mappy.subscriptionservice.repositories;

import com.mappy.subscriptionservice.models.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubscriptionRepository extends MongoRepository<Subscription, Integer> {
    Iterable<Subscription> findAllByAccountId(Long userId);
}
