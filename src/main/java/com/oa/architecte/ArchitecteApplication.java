package com.oa.architecte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients("com.oa.architecte")
public class ArchitecteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArchitecteApplication.class, args);
	}

}
