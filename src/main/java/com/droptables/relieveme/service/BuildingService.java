package com.droptables.relieveme.service;

import com.droptables.relieveme.domain.Building;
import com.droptables.relieveme.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {
    private BuildingRepository buildingRepository;

    /**
     * Service layer for the building table.
     *
     * @param buildingRepository - automatically injected by the Spring framework
     */
    @Autowired
    public BuildingService(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    /**
     * @return a list of all buildings in the building table; empty list if there aren't any buildings
     */
    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }

    /**
     * Access the building table to find the building with the corresponding name.
     *
     * @param properName - official name of a building
     * @return the building where proper_name == properName; null if it can't be found
     */
    public Building getBuildingWithProperName(String properName) {
        return buildingRepository.findByProperName(properName);
    }

    /**
     * Access the building table to find the building with the corresponding id.
     *
     * @param buildingId - id of the building
     * @return the building where building_id == buildingid; null if it can't be found
     */
    public Building getBuildingWithId(int buildingId) {
        return buildingRepository.findByBuildingId(buildingId);
    }
}
