package com.droptables.relieveme.domain.key;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BuildingNameKeyTest {

    @Test
    public void givenDifferentObjectThenEqualsReturnsFalse() {
        assertNotEquals(new BuildingNameKey(), 1);
    }

    @Test
    public void givenDifferentNameThenEqualsReturnsFalse() {
        assertNotEquals(new BuildingNameKey("Different", 10), new BuildingNameKey("Nope", 10));
    }

    @Test
    public void givenDifferentBuildingIdThenEqualsReturnsFalse() {
        assertNotEquals(new BuildingNameKey("Same", 1), new BuildingNameKey("Same", 200));
    }

    @Test
    public void givenSameBuildingIdAndNameThenEqualsReturnsTrue() {
        assertEquals(new BuildingNameKey("Identical", 150), new BuildingNameKey("Identical", 150));
    }

    @Test
    public void givenEqualObjectsThenHashCodeReturnsSame() {
        assertEquals(new BuildingNameKey("Identical", 15).hashCode(), new BuildingNameKey("Identical", 15).hashCode());
    }

    @Test
    public void givenNonEqualObjectsThenHashCodeReturnsDifferent() {
        assertNotEquals(new BuildingNameKey("Different", 12).hashCode(), new BuildingNameKey("Nope", 15).hashCode());
    }
}