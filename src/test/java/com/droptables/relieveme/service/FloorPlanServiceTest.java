package com.droptables.relieveme.service;

import com.droptables.relieveme.domain.FloorPlan;
import com.droptables.relieveme.repository.FloorPlanRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.droptables.relieveme.TestUtils.givenFloorPlan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FloorPlanServiceTest {
    @Mock
    private FloorPlanRepository floorPlanRepository;

    @InjectMocks
    private FloorPlanService floorPlanService;

    @Test
    public void givenExistingBuildingIdReturnsCorrespondingFloorPlans() {
        int existingBuildingId = 13;
        List<FloorPlan> expectedFloorPlans =
                Arrays.asList(givenFloorPlan(existingBuildingId, 1), givenFloorPlan(existingBuildingId, 2));
        when(floorPlanRepository.findByFloorPlanKeyBuildingId(existingBuildingId)).thenReturn(expectedFloorPlans);
        List<FloorPlan> result = floorPlanService.getFloorPlansForBuildingId(existingBuildingId);
        assertEquals((Integer) 2, result.get(1).getFloorPlanKey().getFloorNumber());
    }

    @Test
    public void givenNonexistentBuildingIdReturnsEmptyList() {
        int nonExistentBuildingId = 1;
        when(floorPlanRepository.findByFloorPlanKeyBuildingId(nonExistentBuildingId))
                .thenReturn(Collections.emptyList());
        assertTrue(floorPlanService.getFloorPlansForBuildingId(nonExistentBuildingId).isEmpty());
    }
}