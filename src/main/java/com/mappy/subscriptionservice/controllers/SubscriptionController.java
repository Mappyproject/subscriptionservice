package com.mappy.subscriptionservice.controllers;

import com.mappy.subscriptionservice.models.Subscription;
import com.mappy.subscriptionservice.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8765", maxAge = 3600)
@RequestMapping("/api/subscription")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) { this.subscriptionService = subscriptionService; }
    @GetMapping
    public Iterable<Subscription> getAll() { return subscriptionService.getAll(); }
    @GetMapping(path= "/{subscriptionId}")
    public Optional<Subscription> getById(@PathVariable int subscriptionId) { return subscriptionService.getById(subscriptionId); }
    @PostMapping
    public Subscription save(@RequestBody Subscription subscription) {
        return subscriptionService.save(subscription);
    }
    @PutMapping
    public Subscription update(@RequestBody Subscription subscription) { return subscriptionService.update(subscription); }
    @DeleteMapping
    public void delete(@RequestBody Subscription subscription) { subscriptionService.delete(subscription); }
}
