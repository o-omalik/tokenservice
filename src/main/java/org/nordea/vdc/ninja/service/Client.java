package org.nordea.vdc.ninja.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

@Component
@EnableAutoConfiguration
public class Client {
	
	private String name;
	private String token;
	
	public Client() {}

	public Client(String name) {
		super();
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String key) {
		this.token = key;
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", token=" + token + "]";
	}

}
