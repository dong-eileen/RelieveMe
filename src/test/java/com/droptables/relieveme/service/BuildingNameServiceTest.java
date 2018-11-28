package com.droptables.relieveme.service;

import com.droptables.relieveme.domain.BuildingName;
import com.droptables.relieveme.domain.key.BuildingNameKey;
import com.droptables.relieveme.repository.BuildingNameRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.droptables.relieveme.TestUtils.givenExpectedBuildingName;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BuildingNameServiceTest {
    @Mock
    BuildingNameRepository buildingNameRepository;

    @InjectMocks
    BuildingNameService buildingNameService;

    @Test
    public void whenBuildingNamesExistThenReturnList() {
        when(buildingNameRepository.findAll())
                .thenReturn(Arrays.asList(givenExpectedBuildingName("name1", 1),
                        givenExpectedBuildingName("name10", 10)));
        List<BuildingName> allBuildingNames = buildingNameService.getAllBuildingNames();
        assertEquals(new Integer(1), allBuildingNames.get(0).getBuildingNameKey().getBuildingId());
        assertEquals(new Integer(10), allBuildingNames.get(1).getBuildingNameKey().getBuildingId());
    }

    @Test
    public void whenNoBuildingNamesThenReturnEmptyList() {
        when(buildingNameRepository.findAll())
                .thenReturn(Collections.emptyList());
        assertTrue(buildingNameService.getAllBuildingNames().isEmpty());

    }

    @Test
    public void givenNonExistentBuildingNameReturnNull() {
        assertNull(buildingNameService.getBuildingWithName("blah"));
    }

    @Test
    public void givenExistingBuildingNameReturnNonNull() {
        String expectedName = "test";
        when(buildingNameRepository.findByBuildingNameKeyNameIgnoreCase(expectedName))
                .thenReturn(givenExpectedBuildingName(expectedName, 1));
        BuildingNameKey retBuildingNameKey = buildingNameService.getBuildingWithName(expectedName).getBuildingNameKey();
        assertEquals(expectedName, retBuildingNameKey.getName());
        assertEquals((Integer) 1, retBuildingNameKey.getBuildingId());
    }
}