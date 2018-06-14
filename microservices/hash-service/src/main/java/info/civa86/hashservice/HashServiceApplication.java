package info.civa86.hashservice;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDiscoveryClient
@SpringBootApplication
public class HashServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(HashServiceApplication.class, args);
	}

}