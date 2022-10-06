package com.wubo.test;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.test.context.TestContext;

import javax.sql.DataSource;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Objects;

/**
 * 初始化數據庫
 */
@Slf4j
public class MyDbUnitTestExecutionListener extends TransactionDbUnitTestExecutionListener {

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        createTables(testContext);
        super.beforeTestMethod(testContext);
    }

    private void createTables(TestContext testContext) throws Exception {
        // get db connection
        DataSource ds = (DataSource) testContext.getApplicationContext().getBean(DataSource.class);

        try (Connection conn = ds.getConnection()) {
            String driver = conn.getMetaData().getDriverName();

            // only recreate table when run as H2 db in dbunit
            if (driver.startsWith("H2")) {
                String resourcePath = Objects.requireNonNull(this.getClass().getResource("/data/schema.sql")).getFile();
                log.info("recreate table->{}" , resourcePath);
                String s = getClass().getResource("/data/schema.sql").toURI().toString();
                String ddlSql = s.substring(6);

               // String sql = Files.readString( resourcePath, StandardCharsets.UTF_8);
                String s1 = Files.readString(new File(resourcePath).toPath(), StandardCharsets.UTF_8);

                try (Statement st = conn.createStatement()) {
                    st.execute("runscript from '" + ddlSql + "'");
                }
            }
        }
    }

}
