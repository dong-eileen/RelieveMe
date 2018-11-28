package com.droptables.relieveme.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "regions")
public class Region {
    @Id
    private Integer regionId;
    private String name;

    /**
     * Default constructor for JPA parsing.
     */
    public Region() {
    }

    /**
     * Creates a new region with given regionId and name.
     *
     * @param regionId - id for the region
     * @param name     - name of the region
     */
    public Region(Integer regionId, String name) {
        this.regionId = regionId;
        this.name = name;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
