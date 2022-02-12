package com.algorithms.jianZhi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumSubarrayProductLessThanKTest {
NumSubarrayProductLessThanK numSubarrayProductLessThanK = new NumSubarrayProductLessThanK();
    @Test
    void normalInput() {
    assertEquals(8, numSubarrayProductLessThanK.numSubarrayProductLessThanK(new int[]{10,5,2,6},100));
    assertEquals(0, numSubarrayProductLessThanK.numSubarrayProductLessThanK(new int[]{1,2,3},0));
    assertEquals(6, numSubarrayProductLessThanK.numSubarrayProductLessThanK(new int[]{1,1,1},2));


    }

}