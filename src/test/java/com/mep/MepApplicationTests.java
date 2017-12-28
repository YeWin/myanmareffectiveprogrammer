package com.mep;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.mep.util.TestAbstract;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MepApplicationTests extends TestAbstract {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private DataSource dataSource;

	@Test
	public void contextLoads() {
		assertThat(applicationContext, notNullValue());
		assertThat(dataSource, notNullValue());
	}
}
