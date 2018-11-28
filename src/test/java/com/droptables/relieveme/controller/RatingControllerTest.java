package com.droptables.relieveme.controller;

import com.droptables.relieveme.service.BathroomService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RatingControllerTest {
    @Mock
    private BathroomService bathroomService;

    @InjectMocks
    private RatingController ratingController;

    @Test
    public void givenBathroomIdAndPositiveRatingIncreaseThenIncreaseBathroomPositiveRating() {
        ratingController.increaseBathroomPositiveRating(14);
        verify(bathroomService).incrementNumPositiveRating(14);
    }

    @Test
    public void givenBathroomIdAndNegativeRatingIncreaseThenIncreaseBathroomNegativeRating() {
        ratingController.increaseBathroomNegativeRating(14);
        verify(bathroomService).incrementNumNegativeRating(14);
    }

}