package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * inzheneher created on 22/07/2020 inside the package - application
 */
@SpringBootApplication
@ComponentScan({"application", "controllers", "services"})
@PropertySource("classpath:request.properties")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
