package com.algorithms.jianZhi;

import lombok.extern.slf4j.Slf4j;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class AddBinaryTest {

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        log.info(addBinary.addBinary("1111", "1111"));
        log.info(addBinary.addBinary2("1111", "1111"));
    }
}