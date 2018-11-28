package com.droptables.relieveme.domain;

import com.droptables.relieveme.domain.key.BuildingNameKey;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "building_name")
public class BuildingName {
    @EmbeddedId
    private BuildingNameKey buildingNameKey;

    public BuildingNameKey getBuildingNameKey() {
        return buildingNameKey;
    }

    public void setBuildingNameKey(BuildingNameKey buildingNameKey) {
        this.buildingNameKey = buildingNameKey;
    }
}
