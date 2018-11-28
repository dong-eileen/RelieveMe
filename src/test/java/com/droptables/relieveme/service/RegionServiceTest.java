package com.droptables.relieveme.service;

import com.droptables.relieveme.domain.Region;
import com.droptables.relieveme.repository.RegionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RegionServiceTest {
    @Mock
    private RegionRepository regionRepository;

    @InjectMocks
    private RegionService regionService;

    @Test
    public void givenExistingRegionIdThenReturnName() {
        int existingId = 12;
        Region region = new Region(existingId, "Hello world!");
        when(regionRepository.findById(existingId)).thenReturn(Optional.of(region));
        assertEquals("Hello world!", regionService.getNameOfRegionWithRegionId(existingId));
    }

    @Test
    public void givenNonExistentRegionIdThenReturnNull() {
        assertNull(regionService.getNameOfRegionWithRegionId(1));
    }

    @Test
    public void findAllReturnsAllRegions() {
        when(regionRepository.findAll()).thenReturn(Arrays.asList(new Region(1, "2"), new Region(3, "4")));
        assertEquals("2", regionService.getAllRegions().get(0).getName());
        assertEquals("4", regionService.getAllRegions().get(1).getName());
    }
}