package dev.patricksilva.photoappapiaccountmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PhotoappApiAccountManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhotoappApiAccountManagementApplication.class, args);
    }

}
