package com.algorithms.jianZhi;

import lombok.extern.slf4j.Slf4j;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class MaxProductTest {
    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        log.info(String.valueOf(maxProduct.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"})));
        log.info(String.valueOf(maxProduct.maxProduct(new String[]{"a","ab","abc","d","cd","bcd","abcd"})));
        log.info(String.valueOf(maxProduct.maxProduct(new String[]{"a","aa","aaa","aaaa"})));

    }
}