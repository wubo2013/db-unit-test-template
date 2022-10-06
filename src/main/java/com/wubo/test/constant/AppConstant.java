package com.wubo.test.constant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppConstant {
    private static String TEST_VAR = "test_var";

    public static void logTestVar(){
        log.info("test_var:{}" , TEST_VAR);
    }
}
