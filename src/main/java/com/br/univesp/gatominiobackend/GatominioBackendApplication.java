package com.br.univesp.gatominiobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.br.univesp.gatominiobackend.entity"})
public class GatominioBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatominioBackendApplication.class, args);
	}

}
