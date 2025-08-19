package com.taskhub.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthenticationApplication implements Cloneable {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
		ServletInitializer initializer = new ServletInitializer();


	}
	@Override
	protected Object clone()
			throws CloneNotSupportedException
	{
		return super.clone();
	}
}

}
