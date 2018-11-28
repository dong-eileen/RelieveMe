package com.droptables.relieveme.service;

import com.droptables.relieveme.domain.Region;
import com.droptables.relieveme.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {
    private RegionRepository regionRepository;

    /**
     * The Service layer for the regions table.
     *
     * @param regionRepository - automatically injected by the Spring framework
     */
    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    /**
     * Accesses the regions table to get the name of the region with the given id.
     *
     * @param regionId - the integer id of a region
     * @return the corresponding name of the region where region_id == regionId; null if no matching region exists
     */
    public String getNameOfRegionWithRegionId(int regionId) {
        Optional<Region> possibleRegion = regionRepository.findById(regionId);
        return possibleRegion.map(Region::getName).orElse(null);
    }

    /**
     * @return list of all regions in the regions table. Empty list if there are none.
     */
    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }
}
