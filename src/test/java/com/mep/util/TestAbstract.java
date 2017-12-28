package com.mep.util;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@Configuration
@SpringBootTest
//@PropertySource("classpath:application-test.properties")
//@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace=Replace.NONE)
public abstract class TestAbstract {

}
