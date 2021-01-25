package com.cloud.family;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class CloudFamilyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudFamilyServiceApplication.class, args);
	}

}
