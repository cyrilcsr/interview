package com.algorithms.jianZhi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindromeTest {

    ValidPalindrome validPalindrome = new ValidPalindrome();
    @Test
    void validPalindrome1() {
        assertTrue(validPalindrome.validPalindrome("aba"));
    }
    @Test
    void validPalindrome2() {
        assertTrue(validPalindrome.validPalindrome("abca"));
    }
    @Test
    void validPalindrome3() {
        assertFalse(validPalindrome.validPalindrome("abc"));
    }
    @Test
    void validPalindrome4() {
        assertTrue(validPalindrome.validPalindrome(""));
    }
}