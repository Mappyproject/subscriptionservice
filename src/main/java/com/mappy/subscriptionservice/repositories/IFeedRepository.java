package com.mappy.subscriptionservice.repositories;

import com.mappy.subscriptionservice.models.Feed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFeedRepository extends CrudRepository<Feed, Long> {
}
