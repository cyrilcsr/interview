package com.algorithms.jianZhi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckInclusionTest {

    CheckInclusion checkInclusion = new CheckInclusion();
    @Test
    void checkInclusion() {
        assertEquals(true,checkInclusion.checkInclusion("ab","eidbaooo"));
        assertEquals(true,checkInclusion.checkInclusion("adc","dcda"));

    }
}