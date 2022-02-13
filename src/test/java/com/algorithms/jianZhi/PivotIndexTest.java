package com.algorithms.jianZhi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PivotIndexTest {

    PivotIndex pivotIndex = new PivotIndex();

    @Test
    void input1(){
        assertEquals(3,pivotIndex.pivotIndex(new int[]{1,7,3,6,5,6}));
    }

    @Test
    void input2(){
        assertEquals(-1,pivotIndex.pivotIndex(new int[]{1,2,3}));
    }

    @Test
    void input3(){
        assertEquals(0,pivotIndex.pivotIndex(new int[]{2,1,-1}));
    }

    @Test
    void input4(){
        assertEquals(-1,pivotIndex.pivotIndex(new int[]{-1,-1,-1,1,1,1}));
    }
}