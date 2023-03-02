package dev.patricksilva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class PhotoappConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoappConfigServerApplication.class, args);
	}

}
