package dev.patricksilva.photoappapiusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PhotoappApiUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoappApiUsersApplication.class, args);
	}

}
