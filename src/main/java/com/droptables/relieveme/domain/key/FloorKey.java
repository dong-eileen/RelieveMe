package com.droptables.relieveme.domain.key;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FloorKey implements Serializable {
    private Integer number;
    @Column(name = "building_id")
    private Integer buildingId;

    /**
     * Default constructor for JPA.
     */
    public FloorKey() {
    }

    /**
     * Composite key for Floor
     *
     * @param number     - number of the floor in the building
     * @param buildingId - id of the building the floor is located in
     */
    public FloorKey(Integer number, Integer buildingId) {
        this.number = number;
        this.buildingId = buildingId;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * @param o - object to check equality with
     * @return true if o is of the same class, o.number.equals(this.number), and o.buildingId.equals(this.buildingId);
     * false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof FloorKey) {
            FloorKey otherObject = (FloorKey) o;
            return getNumber().equals(otherObject.getNumber())
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
                .append(getNumber())
                .append(getBuildingId())
                .toHashCode();
    }
}
