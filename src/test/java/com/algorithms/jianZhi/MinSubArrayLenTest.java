package com.algorithms.jianZhi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinSubArrayLenTest {

    MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
    @Test
    void input1(){
        assertEquals(2, minSubArrayLen.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }

}