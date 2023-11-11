package project.camus.database.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {
    "project.camus.database.jpa.*"
})
public class DatabaseJpaApplication {

    public static void main(String[] args) {

        SpringApplication.run(DatabaseJpaApplication.class, args);
    }
}