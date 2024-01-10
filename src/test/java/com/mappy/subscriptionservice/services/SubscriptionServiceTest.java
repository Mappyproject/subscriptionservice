package com.mappy.subscriptionservice.services;

import com.mappy.subscriptionservice.models.Subscription;
import com.mappy.subscriptionservice.repositories.ISubscriptionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SubscriptionServiceTest {

    @Mock
    private ISubscriptionRepository mockSubscriptionRepository;

    private SubscriptionService subscriptionServiceUnderTest;

    @BeforeEach
    void setUp() {
        subscriptionServiceUnderTest = new SubscriptionService(mockSubscriptionRepository);
    }

    @Test
    void testSave() {
        // Setup
        final Subscription subscription = new Subscription(0, 0L, 0L);
        final Subscription expectedResult = new Subscription(0, 0L, 0L);
        when(mockSubscriptionRepository.save(new Subscription(0, 0L, 0L))).thenReturn(new Subscription(0, 0L, 0L));

        // Run the test
        final Subscription result = subscriptionServiceUnderTest.save(subscription);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetAll() {
        // Setup
        when(mockSubscriptionRepository.findAll()).thenReturn(List.of(new Subscription(0, 0L, 0L)));

        // Run the test
        final Iterable<Subscription> result = subscriptionServiceUnderTest.getAll();

        // Verify the results
    }

    @Test
    void testGetAll_ISubscriptionRepositoryReturnsNoItems() {
        // Setup
        when(mockSubscriptionRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final Iterable<Subscription> result = subscriptionServiceUnderTest.getAll();

        // Verify the results
    }

    @Test
    void testGetById() {
        // Setup
        final Optional<Subscription> expectedResult = Optional.of(new Subscription(0, 0L, 0L));
        when(mockSubscriptionRepository.findById(0)).thenReturn(Optional.of(new Subscription(0, 0L, 0L)));

        // Run the test
        final Optional<Subscription> result = subscriptionServiceUnderTest.getById(0);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetById_ISubscriptionRepositoryReturnsAbsent() {
        // Setup
        when(mockSubscriptionRepository.findById(0)).thenReturn(Optional.empty());

        // Run the test
        final Optional<Subscription> result = subscriptionServiceUnderTest.getById(0);

        // Verify the results
        assertThat(result).isEmpty();
    }

    @Test
    void testUpdate() {
        // Setup
        final Subscription subscription = new Subscription(0, 0L, 0L);
        final Subscription expectedResult = new Subscription(0, 0L, 0L);
        when(mockSubscriptionRepository.save(new Subscription(0, 0L, 0L))).thenReturn(new Subscription(0, 0L, 0L));

        // Run the test
        final Subscription result = subscriptionServiceUnderTest.update(subscription);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testDelete() {
        // Setup
        final Subscription subscription = new Subscription(0, 0L, 0L);

        // Run the test
        subscriptionServiceUnderTest.delete(subscription);

        // Verify the results
        verify(mockSubscriptionRepository).delete(new Subscription(0, 0L, 0L));
    }

    @Test
    void testGetByAccountId() {
        // Setup
        when(mockSubscriptionRepository.findAllByAccountId(0L)).thenReturn(List.of(new Subscription(0, 0L, 0L)));

        // Run the test
        final Iterable<Subscription> result = subscriptionServiceUnderTest.getByAccountId(0L);

        // Verify the results
    }

    @Test
    void testGetByAccountId_ISubscriptionRepositoryReturnsNoItems() {
        // Setup
        when(mockSubscriptionRepository.findAllByAccountId(0L)).thenReturn(Collections.emptyList());

        // Run the test
        final Iterable<Subscription> result = subscriptionServiceUnderTest.getByAccountId(0L);

        // Verify the results
    }
}
