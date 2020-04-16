package com.song.Spring_legacy2;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class Test1 extends AbstractTestCase {

	@Autowired
	private DataSource dataSource;
	
	@Test
	public void test() throws Exception{
		
		// assert : 단정문
		assertNotNull(dataSource.getConnection());
		//assertNotEquals(1, );
		//assertEquals(0, );
	}
	

}
