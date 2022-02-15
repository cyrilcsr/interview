package com.algorithms.jianZhi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinWindowTest {

    MinWindow minWindow = new MinWindow();
    @Test
    void minWindow1() {
        assertEquals("BANC",minWindow.minWindow("ADOBECODEBANC","ABC"));
    }

    @Test
    void minWindow2() {
        assertEquals("a",minWindow.minWindow("a","a"));
    }

    @Test
    void minWindow3() {
        assertEquals("",minWindow.minWindow("a","aa"));
    }

    @Test
    void minWindow4() {
        assertEquals("",minWindow.minWindow("abcd","bb"));
    }

    @Test
    void minWindow5() {
        assertEquals("BANC",minWindow.minWindow2("ADOBECODEBANC","ABC"));
    }

    @Test
    void minWindow6() {
        assertEquals("BANC",minWindow.minWindow3("ADOBECODEBANC","ABC"));
    }

    @Test
    void minWindow7() {
        assertEquals("a",minWindow.minWindow3("a","a"));
    }

    @Test
    void minWindow8() {
        assertEquals("",minWindow.minWindow3("a","aa"));
    }

    @Test
    void minWindow9() {
        assertEquals("",minWindow.minWindow3("abcd","bb"));
    }
}