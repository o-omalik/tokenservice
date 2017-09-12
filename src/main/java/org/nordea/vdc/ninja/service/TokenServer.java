package org.nordea.vdc.ninja.service;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@EnableDiscoveryClient
public class TokenServer {

	private Logger logger = Logger.getLogger(TokenServer.class.getName());

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "token-server");
		SpringApplication.run(TokenServer.class, args);
	}

}
