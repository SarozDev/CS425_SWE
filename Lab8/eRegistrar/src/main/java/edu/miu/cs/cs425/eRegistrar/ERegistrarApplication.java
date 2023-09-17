package edu.miu.cs.cs425.eRegistrar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "edu.miu.cs.cs425.eRegistrar")
//@EntityScan("edu.miu.cs.cs425.eRegistrar.model")
//@EntityScan(basePackages = {"edu.miu.cs.cs425.eRegistrar.model"})
public class ERegistrarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ERegistrarApplication.class, args);
	}

}
