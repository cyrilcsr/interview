package com.algorithms.jianZhi;

import lombok.extern.slf4j.Slf4j;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class DivideTwoIntegersTest {
    public static void main(String[] args) {
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        int a = -2147483648;
        int b = 1;
        int result = divideTwoIntegers.divide(a,b);
        log.info("Result is "+ result);
    }
}