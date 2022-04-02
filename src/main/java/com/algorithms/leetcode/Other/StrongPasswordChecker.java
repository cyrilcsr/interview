package com.algorithms.leetcode.Other;

/*
Leeetcode 0420
*/
public class StrongPasswordChecker {
    public int strongPasswordChecker(String password) {
        int len = password.length();
        char[] passwordArray = password.toCharArray();
        int result = 0;
        char prev = passwordArray[0];
        boolean[] characterIdentify = new boolean[3];
        int stepContinues = 0, stepCharacter = 0, count = 0;
        int[] modCount = new int[3];
        for (int i = 0; i < len; i++) {
            if (Character.isLowerCase(passwordArray[i])) characterIdentify[0] = true;
            if (Character.isUpperCase(passwordArray[i])) characterIdentify[1] = true;
            if (Character.isDigit(passwordArray[i])) characterIdentify[2] = true;
            if (passwordArray[i] == prev) {
                count++;
            } else {
                prev = passwordArray[i];
                if (count >= 3) {
                    modCount[count % 3]++;
                    stepContinues += count / 3;
                }
                count = 1;
            }
        }
        if (count >= 3) {
            modCount[count % 3]++;
            stepContinues += count / 3;
        }
        for (int i = 0; i < characterIdentify.length; i++) {
            if (!characterIdentify[i]) stepCharacter++;
        }
        if (len < 6) {
            int min = 6 - len;
            result += Math.max(stepContinues, Math.max(min, stepCharacter));
        } else if (len > 20) {
            int remove = len - 20;
            result += remove;
            while (remove > 0) {
                if (modCount[0] > 0) {
                    if (remove >= modCount[0]) {
                        remove -= modCount[0];
                        stepContinues -= modCount[0];
                        modCount[0] = 0;
                    } else {
                        modCount[0] -= remove;
                        stepContinues -= remove;
                        remove = 0;
                    }
                }
                if (modCount[1] > 0) {
                    if (remove >= modCount[1] * 2) {
                        remove -= modCount[1] * 2;
                        stepContinues -= modCount[1];
                        modCount[1] = 0;
                    } else {
                        modCount[1] -= remove;
                        stepContinues -= remove / 2;
                        remove = 0;
                    }
                }
                stepContinues -= remove / 3;
                remove = 0;
            }
            if (stepContinues > stepCharacter) {
                result += stepContinues;
            } else {
                result += stepCharacter;
            }

        } else {
            result += Math.max(stepContinues, stepCharacter);
        }
        return result;
    }
}
