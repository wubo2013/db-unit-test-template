package com.wubo.test.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

@Component
@Slf4j
public class SystemConfig {
    @Resource
    private Environment environment;

    @Resource
    private DataSource druidDataSource;

    @PostConstruct
    public void init(){
       log.info("profiles->{}" ,environment.getActiveProfiles());

       log.info("dataSource->{}",druidDataSource);
    }
}
