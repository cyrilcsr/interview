package com.algorithms.jianZhi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountSubstringsTest {

    CountSubstrings countSubstrings = new CountSubstrings();
    @Test
    void countSubstrings1() {
        assertEquals(3,countSubstrings.countSubstrings("abc"));
    }

    @Test
    void countSubstrings2() {
        assertEquals(6,countSubstrings.countSubstrings("aaa"));
    }

    @Test
    void countSubstrings3() {
        assertEquals(0,countSubstrings.countSubstrings(""));
    }
}