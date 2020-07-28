package com.mav;

import com.mav.entity.Request;
import com.mav.repository.RequestLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;

/**
 * inzheneher created on 28/07/2020 inside the package - PACKAGE_NAME
 */
@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner test(RequestLogRepository repository) {
        return (args) -> {
            repository.save(new Request(new Timestamp(System.currentTimeMillis()), 36.36, 60.58, "Here should be a json file"));

            log.info("Requests found with findAll():");
            log.info("------------------------------");
            repository.findAll().forEach(request -> log.info(request.toString()));
            log.info("");
        };
    }
}
