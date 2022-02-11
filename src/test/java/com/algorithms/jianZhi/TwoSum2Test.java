package com.algorithms.jianZhi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSum2Test {
    TwoSum2 twoSum2 = new TwoSum2();
@Test
    void testTwoSum2(){
        assertArrayEquals(new int[]{1,2}, twoSum2.twoSum(new int[]{2,7,11,15}, 9));
        assertArrayEquals(new int[]{1,3}, twoSum2.twoSum(new int[]{2,3,4}, 6));
        assertArrayEquals(new int[]{1,2}, twoSum2.twoSum(new int[]{-1,0}, -1));

        }
}