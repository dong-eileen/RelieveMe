package com.droptables.relieveme.domain.key;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FloorPlanKey implements Serializable {
    private Integer buildingId;
    private Integer floorNumber;

    /**
     * Default constructor for JPA
     */
    public FloorPlanKey() {
    }

    /**
     * Composite key for FloorPlan
     *
     * @param buildingId  - id of the building the floor is in
     * @param floorNumber - id of the floor number the floor is in
     */
    public FloorPlanKey(Integer buildingId, Integer floorNumber) {
        this.buildingId = buildingId;
        this.floorNumber = floorNumber;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    /**
     * @param o - object to check equality with
     * @return true if o is of the same class, o.number.equals(this.number), and o.buildingId.equals(this.buildingId);
     * false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof FloorPlanKey) {
            FloorPlanKey otherObject = (FloorPlanKey) o;
            return getFloorNumber().equals(otherObject.getFloorNumber())
                    && getBuildingId().equals(otherObject.getBuildingId());
        }
        return false;
    }

    /**
     * @return hashcode of this object based on this.number and this.buildingId
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getFloorNumber())
                .append(getBuildingId())
                .toHashCode();
    }
}
