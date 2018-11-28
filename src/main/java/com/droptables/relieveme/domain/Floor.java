package com.droptables.relieveme.domain;

import com.droptables.relieveme.domain.key.FloorKey;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "floor")
public class Floor {

    @EmbeddedId
    private FloorKey floorKey;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "building_id", referencedColumnName = "building_id"),
            @JoinColumn(name = "floor_number", referencedColumnName = "number")
    })
    private List<Bathroom> bathrooms;

    public FloorKey getFloorKey() {
        return floorKey;
    }

    public void setFloorKey(FloorKey floorKey) {
        this.floorKey = floorKey;
    }

    public List<Bathroom> getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(List<Bathroom> bathrooms) {
        this.bathrooms = bathrooms;
    }
}
