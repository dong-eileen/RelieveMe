package com.droptables.relieveme.domain.key;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FloorPlanKeyTest {

    @Test
    public void givenDifferentObjectThenEqualsReturnsFalse() {
        assertNotEquals(new FloorPlanKey(), 1);
    }

    @Test
    public void givenDifferentNumberThenEqualsReturnsFalse() {
        assertNotEquals(new FloorPlanKey(1, 10), new FloorPlanKey(2, 10));
    }

    @Test
    public void givenDifferentBuildingIdThenEqualsReturnsFalse() {
        assertNotEquals(new FloorPlanKey(1, 1), new FloorPlanKey(1, 200));
    }

    @Test
    public void givenSameNumberAndBuildingIdThenEqualsReturnsTrue() {
        assertEquals(new FloorPlanKey(1, 150), new FloorPlanKey(1, 150));
    }

    @Test
    public void givenEqualObjectsThenHashCodeReturnsSame() {
        assertEquals(new FloorPlanKey(1, 15).hashCode(), new FloorPlanKey(1, 15).hashCode());
    }

    @Test
    public void givenNonEqualObjectsThenHashCodeReturnsDifferent() {
        assertNotEquals(new FloorPlanKey(2, 12).hashCode(), new FloorPlanKey(3, 15).hashCode());
    }

}