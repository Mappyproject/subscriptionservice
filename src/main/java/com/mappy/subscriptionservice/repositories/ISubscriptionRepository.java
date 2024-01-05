package com.mappy.subscriptionservice.repositories;

import com.mappy.subscriptionservice.models.Subscription;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubscriptionRepository extends CrudRepository<Subscription, Long> {
    @Query(value = "SELECT s FROM Subscription s where s.accountId = ?1")
    Iterable<Subscription> findAllByAccountId(Long userId);
}
