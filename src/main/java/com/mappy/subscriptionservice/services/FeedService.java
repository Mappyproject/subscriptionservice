package com.mappy.subscriptionservice.services;

import com.mappy.subscriptionservice.models.Feed;
import com.mappy.subscriptionservice.repositories.IFeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FeedService implements IFeedService {
    private final IFeedRepository feedRepository;

    @Override
    public Feed save(Feed feed) {
        return feedRepository.save(feed);
    }

    @Override
    public Optional<Feed> getById(Long id) {
        return feedRepository.findById(id);
    }

    @Override
    public Feed update(Feed feed) {
        return feedRepository.save(feed);
    }

    @Override
    public void delete(Feed feed) {
        feedRepository.delete(feed);
    }
}
