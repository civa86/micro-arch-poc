package info.civa86.uuidservice;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDiscoveryClient
@SpringBootApplication
public class UuidServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(UuidServiceApplication.class, args);
	}
}
