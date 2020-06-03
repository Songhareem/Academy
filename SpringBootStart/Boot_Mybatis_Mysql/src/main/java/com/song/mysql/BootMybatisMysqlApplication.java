package com.song.mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class BootMybatisMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMybatisMysqlApplication.class, args);
	}

}
