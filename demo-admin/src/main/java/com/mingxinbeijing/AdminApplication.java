package com.mingxinbeijing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.mingxinbeijing"})
@EnableFeignClients
@EnableDiscoveryClient
public class AdminApplication{
	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}
}
