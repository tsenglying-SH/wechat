package com.jiuting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.jiuting","org.n3r.idworker"})
public class MywechatApplication {

	public static void main(String[] args) {
		SpringApplication.run(MywechatApplication.class, args);
	}

}
