package com.mappy.subscriptionservice.consumer;

import com.mappy.subscriptionservice.dto.AccountFeedDto;
import com.mappy.subscriptionservice.models.Feed;
import com.mappy.subscriptionservice.models.Subscription;
import com.mappy.subscriptionservice.services.FeedService;
import com.mappy.subscriptionservice.services.SubscriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);
    @Autowired
    private FeedService feedService;
    @Autowired
    private SubscriptionService subscriptionService;

    @RabbitListener(queues = {"${rabbitmq.queue.feed.name}"})
    public void consumeJsonMessage(AccountFeedDto accountFeedDto) {
        LOGGER.info(String.format("Received JSON message -> %s", accountFeedDto.toString()));
        saveAccountFeedData(accountFeedDto);
        saveSubscriptionData(accountFeedDto);
    }

    public void saveAccountFeedData(AccountFeedDto accountFeedDto) {
        // if feed with account id already exists it will update
        Iterable<Feed> feeds = feedService.getByAccountId(accountFeedDto.getAccountId());
        for(Feed feed : feeds) {
            if(feed.getAccountId().equals(accountFeedDto.getAccountId())) {
                feed.setProject_ids(accountFeedDto.getProject_ids());
                feedService.save(feed);
            }
        }
        // if feed with account id does not exist it will create a new feed
        Feed feed = new Feed(accountFeedDto.getAccountId(), accountFeedDto.getProject_ids());
        feedService.save(feed);
    }

    public void saveSubscriptionData(AccountFeedDto accountFeedDto) {
        // if subscription with account id already exists it will update
        Iterable<Subscription> subscriptions = subscriptionService.getByAccountId(accountFeedDto.getAccountId());
        for(Subscription subscription : subscriptions) {
            if(subscription.getAccountId().equals(accountFeedDto.getAccountId())) {
                for(Long projectId : accountFeedDto.getProject_ids()) {
                    subscription.setProjectId(projectId);
                    subscriptionService.save(subscription);
                }
            }
        }
        // if subscription with account id does not exist it will create a new subscription
        for(Long projectId : accountFeedDto.getProject_ids()) {
            Subscription subscription = new Subscription(accountFeedDto.getAccountId(), projectId);
            subscriptionService.save(subscription);
        }
    }
}
