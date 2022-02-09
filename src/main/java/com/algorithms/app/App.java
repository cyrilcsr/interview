package com.algorithms.app;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    public static void main(String[] args) {
        testLeftBitShift();
        testRightBitShift();
    }

    public static void testLeftBitShift(){
        int a = 2;
        int b = a<<1;
        log.info("a = "+ a + "  b = " + b);
    }

    public static void testRightBitShift(){
        int a = -5;
        int b = a>>1;
        log.info("a = "+ a + "  b = " + b);
    }
}
