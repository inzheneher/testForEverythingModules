package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * inzheneher created on 22/07/2020 inside the package - application
 */
@SpringBootApplication
@ComponentScan({"application", "controllers", "services"})
@EntityScan("entity")
@EnableJpaRepositories("repository")
@PropertySource("classpath:request.properties")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
