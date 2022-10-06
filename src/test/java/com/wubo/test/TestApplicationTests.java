package com.wubo.test;

import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.wubo.test.config.MockConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

@SpringBootTest(classes = {TestApplication.class, MockConfig.class},
		properties = "spring.datasource.druid.web-stat-filter.enabled=false")
@ContextConfiguration
@TestExecutionListeners({
		DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		MyDbUnitTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class
})
@DbUnitConfiguration(databaseConnection = "dbUnitDatabaseConnection")
@RunWith(SpringRunner.class)
//保证每次运行测试用例都会重新初始spring上下文
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Slf4j
@ActiveProfiles({"unittest"})
public abstract class TestApplicationTests {

	protected void  mock(){

	}
}
