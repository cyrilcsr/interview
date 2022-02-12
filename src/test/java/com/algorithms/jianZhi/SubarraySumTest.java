package com.algorithms.jianZhi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubarraySumTest {

    SubarraySum subarraySum = new SubarraySum();

    @Test
    void normalInput1(){
        assertEquals(2,subarraySum.subarraySum(new int[]{1,1,1},2));
    }

    @Test
    void normalInput2(){
        assertEquals(2,subarraySum.subarraySum(new int[]{1,2,3},3));
    }
}