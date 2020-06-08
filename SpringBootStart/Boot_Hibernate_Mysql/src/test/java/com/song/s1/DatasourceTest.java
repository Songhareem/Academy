package com.song.s1;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DatasourceTest {

	@Autowired
	private DataSource dataSource;
	
	@Test
	void dataSourceTest() throws Exception{
		assertNotNull(dataSource.getConnection());
	}

}
