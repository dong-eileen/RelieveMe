package com.droptables.relieveme;

import com.droptables.relieveme.domain.Building;
import com.droptables.relieveme.domain.BuildingName;
import com.droptables.relieveme.domain.FloorPlan;
import com.droptables.relieveme.domain.Region;
import com.droptables.relieveme.domain.key.BuildingNameKey;
import com.droptables.relieveme.domain.key.FloorPlanKey;

public class TestUtils {
    public static FloorPlan givenFloorPlan(Integer buildingId, Integer floorNumber) {
        FloorPlan floorPlan = new FloorPlan();
        floorPlan.setFloorPlanKey(new FloorPlanKey(buildingId, floorNumber));
        return floorPlan;
    }

    public static Building givenBuilding(Integer buildingId) {
        Building building = new Building();
        building.setBuildingId(buildingId);
        return building;
    }

    public static BuildingName givenExpectedBuildingName(String name, Integer buildingId) {
        BuildingNameKey buildingNameKey = new BuildingNameKey(name, buildingId);
        BuildingName buildingName = new BuildingName();
        buildingName.setBuildingNameKey(buildingNameKey);
        return buildingName;
    }
}
