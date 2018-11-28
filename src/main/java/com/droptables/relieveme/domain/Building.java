package com.droptables.relieveme.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "building")
public class Building {
    @Id
    private Integer buildingId;

    private String properName;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "building_id")
    private List<Floor> floors;

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getProperName() {
        return properName;
    }

    public void setProperName(String properName) {
        this.properName = properName;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }
}
