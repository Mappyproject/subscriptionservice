package com.mappy.subscriptionservice.repositories;

import com.mappy.subscriptionservice.models.Feed;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFeedRepository extends CrudRepository<Feed, Long> {
    @Query(value = "SELECT f FROM Feed f where f.accountId = ?1")
    Iterable<Feed> findAllByAccountId(Long userId);
}
