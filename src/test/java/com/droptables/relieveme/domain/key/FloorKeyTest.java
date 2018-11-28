package com.droptables.relieveme.domain.key;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FloorKeyTest {

    @Test
    public void givenDifferentObjectThenEqualsReturnsFalse() {
        assertNotEquals(new FloorKey(), 1);
    }

    @Test
    public void givenDifferentNumberThenEqualsReturnsFalse() {
        assertNotEquals(new FloorKey(1, 10), new FloorKey(2, 10));
    }

    @Test
    public void givenDifferentBuildingIdThenEqualsReturnsFalse() {
        assertNotEquals(new FloorKey(1, 1), new FloorKey(1, 200));
    }

    @Test
    public void givenSameNumberAndBuildingIdThenEqualsReturnsTrue() {
        assertEquals(new FloorKey(1, 150), new FloorKey(1, 150));
    }

    @Test
    public void givenEqualObjectsThenHashCodeReturnsSame() {
        assertEquals(new FloorKey(1, 15).hashCode(), new FloorKey(1, 15).hashCode());
    }

    @Test
    public void givenNonEqualObjectsThenHashCodeReturnsDifferent() {
        assertNotEquals(new FloorKey(2, 12).hashCode(), new FloorKey(3, 15).hashCode());
    }

}