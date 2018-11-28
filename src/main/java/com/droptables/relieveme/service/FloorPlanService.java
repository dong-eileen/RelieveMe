package com.droptables.relieveme.service;

import com.droptables.relieveme.domain.FloorPlan;
import com.droptables.relieveme.repository.FloorPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorPlanService {
    private FloorPlanRepository floorPlanRepository;

    /**
     * The Service layer for the floor_plan table.
     *
     * @param floorPlanRepository - automatically injected by the Spring framework
     */
    @Autowired
    public FloorPlanService(FloorPlanRepository floorPlanRepository) {
        this.floorPlanRepository = floorPlanRepository;
    }

    /**
     * Accesses the floor_plan table to get the floor plans for a building.
     *
     * @param buildingId - the integer id of a building
     * @return a list of floor plans corresponding to a building; returns an empty list if there aren't any
     */
    public List<FloorPlan> getFloorPlansForBuildingId(int buildingId) {
        return floorPlanRepository.findByFloorPlanKeyBuildingId(buildingId);
    }
}
