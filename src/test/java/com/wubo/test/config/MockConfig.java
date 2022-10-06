package com.wubo.test.config;

import com.github.springtestdbunit.bean.DatabaseConfigBean;
import com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean;
import com.wubo.test.rpc.ITestFeignService;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MockConfig {
    @Bean(name = "dbUnitDatabaseConfig")
    public DatabaseConfigBean dbUnitDatabaseConfig() {
        DatabaseConfigBean config = new DatabaseConfigBean();
        H2DataTypeFactory h2DataTypeFactory = new H2DataTypeFactory();
        config.setDatatypeFactory(h2DataTypeFactory);
        config.setEscapePattern("\"?\"");
        config.setCaseSensitiveTableNames(false);
        config.setAllowEmptyFields(true);
        return config;
    }

    @Bean("dbUnitDatabaseConnection")
    public DatabaseDataSourceConnectionFactoryBean webDbUnitDatabaseConnection(DataSource ds) {
        DatabaseDataSourceConnectionFactoryBean con = new DatabaseDataSourceConnectionFactoryBean(ds);
        con.setDatabaseConfig(dbUnitDatabaseConfig());
        return con;
    }

    @Bean
    public ITestFeignService testFeignService(){
        return  Mockito.mock(ITestFeignService.class);
    }

}
