package com.gdms.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestLog4j {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(TestLog4j.class);
//        logger.debug("debug");
//        logger.error("error");
        logger.info("输出");
    }
}
