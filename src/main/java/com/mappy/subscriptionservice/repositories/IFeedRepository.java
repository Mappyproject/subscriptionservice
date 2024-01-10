package com.mappy.subscriptionservice.repositories;

import com.mappy.subscriptionservice.models.Feed;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFeedRepository extends MongoRepository<Feed, Integer> {
    Iterable<Feed> findAllByAccountId(Long userId);
}
