package com.algorithms.jianZhi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvalRPNTest {

    EvalRPN evalRPN = new EvalRPN();
    @Test
    void evalRPN() {
        assertEquals(6,evalRPN.evalRPN(new String[]{"4","13","5","/","+"}));
        assertEquals(22,evalRPN.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}