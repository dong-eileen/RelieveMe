package com.droptables.relieveme.domain;

import com.droptables.relieveme.domain.key.FloorPlanKey;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "floor_plan")
public class FloorPlan {

    @EmbeddedId
    private FloorPlanKey floorPlanKey;

    private String link;

    public FloorPlanKey getFloorPlanKey() {
        return floorPlanKey;
    }

    public void setFloorPlanKey(FloorPlanKey floorPlanKey) {
        this.floorPlanKey = floorPlanKey;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
