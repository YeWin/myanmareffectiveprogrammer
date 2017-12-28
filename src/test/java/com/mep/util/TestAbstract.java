package com.mep.util;

import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.context.junit4.SpringRunner;

//@Configuration
//@PropertySource("classpath:application-test.properties")
//@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace=Replace.NONE)
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public abstract class TestAbstract {

}
