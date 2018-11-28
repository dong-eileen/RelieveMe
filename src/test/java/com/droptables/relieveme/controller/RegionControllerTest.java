package com.droptables.relieveme.controller;

import com.droptables.relieveme.domain.Region;
import com.droptables.relieveme.service.RegionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RegionControllerTest {

    @Mock
    private RegionService regionService;

    @InjectMocks
    private RegionController regionController;

    @Test
    public void getAllRegionsReturnsRegions() {
        when(regionService.getAllRegions()).thenReturn(Collections.singletonList(new Region(65, "1")));
        assertEquals((Integer) 65, regionController.getAllRegions().get(0).getRegionId());
    }
}