package com.algorithms.jianZhi;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumTest {
    ThreeSum threeSum = new ThreeSum();

    @Test
    void threeSumTest(){
        assertEquals(new ArrayList(),threeSum.threeSum(new int[]{}));
        assertEquals(new ArrayList(),threeSum.threeSum(new int[]{0}));
//        assertEquals(new ArrayList(),threeSum.threeSum(new int[]{0,0,0,0}));

        assertEquals(new ArrayList(),threeSum.threeSum(new int[]{-1,0,1,2,-1,-4}));

    }

}