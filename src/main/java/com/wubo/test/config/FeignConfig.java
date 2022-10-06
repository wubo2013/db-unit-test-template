package com.wubo.test.config;

import feign.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level deviceSendCmdFeignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
