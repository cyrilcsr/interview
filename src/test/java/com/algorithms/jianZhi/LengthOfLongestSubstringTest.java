package com.algorithms.jianZhi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthOfLongestSubstringTest {

    LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
    @Test
    void lengthOfLongestSubstring1() {
        assertEquals(3,lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb"));
    }
    @Test
    void lengthOfLongestSubstring2() {
        assertEquals(1,lengthOfLongestSubstring.lengthOfLongestSubstring("bbbbbbb"));
    }

    @Test
    void lengthOfLongestSubstring3() {
        assertEquals(3,lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    void lengthOfLongestSubstring4() {
        assertEquals(2,lengthOfLongestSubstring.lengthOfLongestSubstring("bbbba"));
    }

}