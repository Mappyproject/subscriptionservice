package com.mappy.subscriptionservice.services;

import com.mappy.subscriptionservice.models.Feed;

import java.util.Optional;

public interface IFeedService {
    Feed save(Feed feed);
    Optional<Feed> getById(Long id);
    Feed update(Feed feed);
    void delete(Feed feed);
    Iterable<Feed> getByAccountId(Long userId);
}
