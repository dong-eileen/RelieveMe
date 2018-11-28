package com.droptables.relieveme.service;

import com.droptables.relieveme.domain.Building;
import com.droptables.relieveme.repository.BuildingRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BuildingServiceTest {
    @Mock
    BuildingRepository buildingRepository;

    @InjectMocks
    BuildingService buildingService;

    private Building expectedBuilding;

    @Before
    public void setUp() {
        givenExpectedBuilding();
    }

    @Test
    public void givenNoBuildingsReturnsEmptyList() {
        when(buildingRepository.findAll()).thenReturn(Collections.emptyList());
        assertTrue(buildingService.getAllBuildings().isEmpty());
    }

    @Test
    public void givenBuildingsReturnsExpectedBuildings() {
        int expectedBuildingId = 3;
        expectedBuilding.setBuildingId(expectedBuildingId);
        List<Building> buildings = Collections.singletonList(expectedBuilding);
        when(buildingRepository.findAll()).thenReturn(buildings);
        assertEquals((Integer) expectedBuildingId, buildingService.getAllBuildings().get(0).getBuildingId());
    }

    @Test
    public void givenNonExistentProperNameReturnsNull() {
        assertNull(buildingService.getBuildingWithProperName("Blah"));
    }

    @Test
    public void givenExistingProperNameReturnsBuilding() {
        String properName = "Rensselaer Union";
        expectedBuilding.setProperName(properName);
        when(buildingRepository.findByProperName(properName)).thenReturn(expectedBuilding);
        assertSame(buildingService.getBuildingWithProperName(properName), expectedBuilding);
    }

    @Test
    public void givenNonExistentBuildingIdReturnsNull() {
        assertNull(buildingService.getBuildingWithId(-1));
    }

    @Test
    public void givenExistingBuildingIdReturnsBuilding() {
        expectedBuilding.setBuildingId(1);
        when(buildingRepository.findByBuildingId(1)).thenReturn(expectedBuilding);
        assertSame(buildingService.getBuildingWithId(1), expectedBuilding);
    }

    private void givenExpectedBuilding() {
        expectedBuilding = new Building();
    }
}