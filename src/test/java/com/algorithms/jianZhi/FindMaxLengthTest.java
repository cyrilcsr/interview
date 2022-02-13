package com.algorithms.jianZhi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMaxLengthTest {

    FindMaxLength findMaxLength = new FindMaxLength();
    @Test
    void input1(){
        assertEquals(2,findMaxLength.findMaxLength(new int[]{0,1}));
    }

    @Test
    void input2(){
        assertEquals(2,findMaxLength.findMaxLength(new int[]{0,1,0}));
    }

    @Test
    void input3(){
        assertEquals(4,findMaxLength.findMaxLength(new int[]{0,1,0,1}));
    }
    @Test
    void input4(){
        assertEquals(0,findMaxLength.findMaxLength(new int[]{0,0,0,0,0,0}));
    }


}