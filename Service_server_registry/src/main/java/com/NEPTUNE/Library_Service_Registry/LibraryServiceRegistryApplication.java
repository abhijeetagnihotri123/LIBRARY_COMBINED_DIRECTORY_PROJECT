package com.NEPTUNE.Library_Service_Registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LibraryServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryServiceRegistryApplication.class, args);
	}

}
