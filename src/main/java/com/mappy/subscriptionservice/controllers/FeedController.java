package com.mappy.subscriptionservice.controllers;

import com.mappy.subscriptionservice.models.Feed;
import com.mappy.subscriptionservice.services.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/feed")
public class FeedController {
    private final FeedService feedService;

    @Autowired
    public FeedController(FeedService feedService) { this.feedService = feedService; }
    @GetMapping(path= "/{feedId}")
    public Optional<Feed> getById(@PathVariable Long feedId) { return feedService.getById(feedId); }
    @PostMapping
    public Feed save(@RequestBody Feed feed) { return feedService.save(feed); }
    @PutMapping
    public Feed update(@RequestBody Feed feed) { return feedService.update(feed); }
    @DeleteMapping
    public void delete(@RequestBody Feed feed) { feedService.delete(feed); }

    @GetMapping(path="/generate/{userId}")
    public Feed feedGenerator(@PathVariable Long userId) { return null; }
}
