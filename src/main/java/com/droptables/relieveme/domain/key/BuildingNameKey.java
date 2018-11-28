package com.droptables.relieveme.domain.key;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BuildingNameKey implements Serializable {

    private String name;
    private Integer buildingId;

    /**
     * Default constructor for JPA
     */
    public BuildingNameKey() {
    }

    /**
     * Composite key for BuildingName
     *
     * @param name       - nickname
     * @param buildingId - id of the building that this.name is associated with
     */
    public BuildingNameKey(String name, Integer buildingId) {
        this.name = name;
        this.buildingId = buildingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    /**
     * @param o - object to check equality with
     * @return true if o is of the same class, o.name.equals(this.name), and o.buildingId.equals(this.buildingId);
     * false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof BuildingNameKey) {
            BuildingNameKey otherObject = (BuildingNameKey) o;
            return getName().equals(otherObject.getName())
                    && getBuildingId().equals(otherObject.getBuildingId());
        }
        return false;
    }

    /**
     * @return hashcode of this object based on this.name and this.buildingId
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getName())
                .append(getBuildingId())
                .toHashCode();
    }
}
