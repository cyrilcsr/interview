package com.algorithms.jianZhi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsPalindromeTest {

    IsPalindrome isPalindrome = new IsPalindrome();
    @Test
    void isPalindrome1() {
        assertTrue(isPalindrome.isPalindrome("A man, a plan, a canal: Panama"));

    }
    @Test
    void isPalindrome2() {
        assertFalse(isPalindrome.isPalindrome("race a car"));

    }

    @Test
    void isPalindrome3() {
        assertTrue(isPalindrome.isPalindrome(" "));
    }

    @Test
    void isPalindrome4() {
        assertTrue(isPalindrome.isPalindrome(""));
    }

}