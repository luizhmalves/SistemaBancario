package br.com.sistemabancario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories(basePackages = "br.com.sistemabancario.dao")
@SpringBootApplication
public class SistemaBancarioApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(SistemaBancarioApplication.class, args);
	}

}
