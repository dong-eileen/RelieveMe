package com.droptables.relieveme.repository;

import com.droptables.relieveme.domain.FloorPlan;
import com.droptables.relieveme.domain.key.FloorPlanKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FloorPlanRepository extends JpaRepository<FloorPlan, FloorPlanKey> {

    /**
     * Returns all floor plans from floor_plan where building_id column matches the given buildingId.
     * Spring parses the method name as a SQL query.
     *
     * @param buildingId - the id of the building to get floor plans for
     * @return a list of floor plans corresponding to a building; returns an empty list if there aren't any
     */
    List<FloorPlan> findByFloorPlanKeyBuildingId(Integer buildingId);
}