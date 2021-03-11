package com.co.canchasintetica.microservicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan({"com.co.canchasintetica"})
@SpringBootApplication
public class CanchaSinteticaApplication {
	public static void main(String[] args) {
		SpringApplication.run(CanchaSinteticaApplication.class, args);
	}

}
