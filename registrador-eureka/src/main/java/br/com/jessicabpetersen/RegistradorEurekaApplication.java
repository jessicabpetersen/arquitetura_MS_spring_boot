package br.com.jessicabpetersen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegistradorEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistradorEurekaApplication.class, args);
	}

}
