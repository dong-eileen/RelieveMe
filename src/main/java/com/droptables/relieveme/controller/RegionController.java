package com.droptables.relieveme.controller;

import com.droptables.relieveme.domain.Region;
import com.droptables.relieveme.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${rest-controller-prefix}/regions")
public class RegionController {

    private final RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    /**
     * @return a list of all regions. Empty list if there are none.
     */
    @GetMapping("")
    public List<Region> getAllRegions() {
        return regionService.getAllRegions();
    }

}
