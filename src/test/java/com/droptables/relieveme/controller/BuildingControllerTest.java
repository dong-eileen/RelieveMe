package com.droptables.relieveme.controller;

import com.droptables.relieveme.domain.Building;
import com.droptables.relieveme.domain.FloorPlan;
import com.droptables.relieveme.service.BuildingNameService;
import com.droptables.relieveme.service.BuildingService;
import com.droptables.relieveme.service.FloorPlanService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.droptables.relieveme.TestUtils.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BuildingControllerTest {

    @Mock
    private BuildingService buildingService;

    @Mock
    private FloorPlanService floorPlanService;

    @Mock
    private BuildingNameService buildingNameService;

    @InjectMocks
    private BuildingController buildingController;

    @Test
    public void whenBuildingsExistReturnsListOfBuildings() {
        when(buildingService.getAllBuildings()).thenReturn(Arrays.asList(givenBuilding(100), givenBuilding(12)));
        assertThat(buildingController.getAllBuildings().get(0).getBuildingId(), is(100));
        assertThat(buildingController.getAllBuildings().get(1).getBuildingId(), is(12));
    }

    @Test
    public void whenNoBuildingsReturnsEmptyList() {
        when(buildingService.getAllBuildings()).thenReturn(Collections.emptyList());
        assertTrue(buildingController.getAllBuildings().isEmpty());
    }

    @Test
    public void givenBuildingNameReturnsCorrespondingFloorPlans() {
        int expectedBuildingId = 1;
        List<FloorPlan> expectedFloorPlans = Arrays.asList(givenFloorPlan(expectedBuildingId, 3),
                givenFloorPlan(expectedBuildingId, 4));
        Building expectedBuilding = givenBuilding(expectedBuildingId);
        String buildingName = "Poop";
        when(buildingService.getBuildingWithProperName(buildingName)).thenReturn(expectedBuilding);
        when(floorPlanService.getFloorPlansForBuildingId(expectedBuildingId)).thenReturn(expectedFloorPlans);
        List<FloorPlan> result = buildingController.getFloorPlans(buildingName);
        assertEquals((Integer) 4, result.get(1).getFloorPlanKey().getFloorNumber());
    }

    @Test
    public void givenBuildingNameWithNoFloorPlansReturnsEmptyList() {
        String buildingName = "Poop";
        when(buildingService.getBuildingWithProperName(buildingName)).thenReturn(givenBuilding(2));
        assertTrue(buildingController.getFloorPlans(buildingName).isEmpty());
    }

    @Test
    public void givenNonExistentBuildingNameReturnsEmptyList() {
        assertTrue(buildingController.getFloorPlans("blob").isEmpty());
    }

    @Test
    public void givenNonEmptyBuildingNamesThenReturnAllBuildingNames() {
        when(buildingNameService.getAllBuildingNames()).thenReturn(
                Arrays.asList(givenExpectedBuildingName("notExpected", 1), givenExpectedBuildingName("expected", 100)));
        assertEquals("expected", buildingController.getAllBuildingNames().get(1));
    }

    @Test
    public void givenExistingBuildingNameReturnsCorrespondingBuilding() {
        when(buildingNameService.getBuildingWithName("POop")).thenReturn(givenExpectedBuildingName("POop", 100));
        Building expBuilding = new Building();
        when(buildingService.getBuildingWithId(100)).thenReturn(expBuilding);
        expBuilding.setBuildingId(100);
        assertEquals((Integer) 100, buildingController.getBuilding("POop").getBuildingId());
    }

    @Test
    public void givenNonExistentBuildingNameReturnsNull() {
        assertNull(buildingController.getBuilding("nothing is expected"));
    }
}