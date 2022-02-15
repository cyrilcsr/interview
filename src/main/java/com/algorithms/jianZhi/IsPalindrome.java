package com.algorithms.jianZhi;

import java.util.Locale;

/*
JianZhi Offer 2-018
Leeetcode 0125
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int low = 0, high = s.length() - 1;
        while (low < high) {
            char c1 = s.charAt(low);
            char c2 = s.charAt(high);

            if (!Character.isLetterOrDigit(c1)) {
                low++;
            } else if (!Character.isLetterOrDigit(c2)) {
                high--;
            } else {
                if (c1 != c2) {
                    return false;
                } else {
                    low++;
                    high--;
                }
            }
        }

        return true;
    }

    public boolean isPalindrome2(String s) {
        s = s.toLowerCase();
        int low = 0, high = s.length() - 1;
        while (low < high) {
            char c1 = s.charAt(low);
            char c2 = s.charAt(high);

            if (isInvalidCharacter(c1)) {
                low++;
            } else if (isInvalidCharacter(c2)) {
                high--;
            } else {
                if (c1 != c2) {
                    return false;
                } else {
                    low++;
                    high--;
                }
            }
        }

        return true;
    }

    private static boolean isInvalidCharacter(char c) {
        return (c < '0' || c > '9')
                && (c < 'a' || c > 'z');
    }
}
