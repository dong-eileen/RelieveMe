package com.droptables.relieveme.service;

import com.droptables.relieveme.repository.BathroomRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BathroomServiceTest {

    @Mock
    private BathroomRepository bathroomRepository;

    @InjectMocks
    private BathroomService bathroomService;

    @Test
    public void givenBathroomIdWhenIncrementPositiveRatingThenCallBathroomRepository() {
        bathroomService.incrementNumPositiveRating(12);
        verify(bathroomRepository).incrementNumPositiveRating(12);
    }

    @Test
    public void givenBathroomIdWhenIncrementNegativeRatingThenCallBathroomRepository() {
        bathroomService.incrementNumNegativeRating(12);
        verify(bathroomRepository).incrementNumNegativeRating(12);
    }

    @Test
    public void givenBathroomIdWhenOngoingBathroomIssueThenCallBathroomRepository() {
        bathroomService.setOngoingBathroomIssueToTrue(1);
        verify(bathroomRepository).setOngoingBathroomIssueToTrue(1);
    }
}