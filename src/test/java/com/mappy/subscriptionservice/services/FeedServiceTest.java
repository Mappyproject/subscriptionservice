package com.mappy.subscriptionservice.services;

import com.mappy.subscriptionservice.models.Feed;
import com.mappy.subscriptionservice.repositories.IFeedRepository;
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
class FeedServiceTest {

    @Mock
    private IFeedRepository mockFeedRepository;

    private FeedService feedServiceUnderTest;

    @BeforeEach
    void setUp() {
        feedServiceUnderTest = new FeedService(mockFeedRepository);
    }

    @Test
    void testSave() {
        // Setup
        final Feed feed = new Feed(0, 0L, List.of(0L));
        final Feed expectedResult = new Feed(0, 0L, List.of(0L));
        when(mockFeedRepository.save(new Feed(0, 0L, List.of(0L)))).thenReturn(new Feed(0, 0L, List.of(0L)));

        // Run the test
        final Feed result = feedServiceUnderTest.save(feed);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetById() {
        // Setup
        final Optional<Feed> expectedResult = Optional.of(new Feed(0, 0L, List.of(0L)));

        // Configure IFeedRepository.findById(...).
        final Optional<Feed> feed = Optional.of(new Feed(0, 0L, List.of(0L)));
        when(mockFeedRepository.findById(0)).thenReturn(feed);

        // Run the test
        final Optional<Feed> result = feedServiceUnderTest.getById(0);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetById_IFeedRepositoryReturnsAbsent() {
        // Setup
        when(mockFeedRepository.findById(0)).thenReturn(Optional.empty());

        // Run the test
        final Optional<Feed> result = feedServiceUnderTest.getById(0);

        // Verify the results
        assertThat(result).isEmpty();
    }

    @Test
    void testUpdate() {
        // Setup
        final Feed feed = new Feed(0, 0L, List.of(0L));
        final Feed expectedResult = new Feed(0, 0L, List.of(0L));
        when(mockFeedRepository.save(new Feed(0, 0L, List.of(0L)))).thenReturn(new Feed(0, 0L, List.of(0L)));

        // Run the test
        final Feed result = feedServiceUnderTest.update(feed);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testDelete() {
        // Setup
        final Feed feed = new Feed(0, 0L, List.of(0L));

        // Run the test
        feedServiceUnderTest.delete(feed);

        // Verify the results
        verify(mockFeedRepository).delete(new Feed(0, 0L, List.of(0L)));
    }

    @Test
    void testGetByAccountId() {
        // Setup
        when(mockFeedRepository.findAllByAccountId(0L)).thenReturn(List.of(new Feed(0, 0L, List.of(0L))));

        // Run the test
        final Iterable<Feed> result = feedServiceUnderTest.getByAccountId(0L);

        // Verify the results
    }

    @Test
    void testGetByAccountId_IFeedRepositoryReturnsNoItems() {
        // Setup
        when(mockFeedRepository.findAllByAccountId(0L)).thenReturn(Collections.emptyList());

        // Run the test
        final Iterable<Feed> result = feedServiceUnderTest.getByAccountId(0L);

        // Verify the results
    }
}
