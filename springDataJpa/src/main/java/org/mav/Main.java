package org.mav;

import org.mav.dao.Movie;
import org.mav.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    private final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner demo(MovieRepository repository) {
        return args -> {
            //save a few movies to db
            repository.save(new Movie("/home/inzheneher/Home_along.avi"));
            repository.save(new Movie("/home/inzheneher/American_ninja.mp4"));

            //fetch all movies
            logger.info("Movies found with findAll():");
            logger.info("----------------------------");
            repository.findAll().forEach(movie -> logger.info(movie.toString()));
            logger.info("");

            //fetch an individual movie by ID
            Movie movie = repository.findById(1L);
            logger.info("Movie found with findById(1L):");
            logger.info("------------------------------");
            logger.info(movie.toString());
            logger.info("");

            //fetch movies by name
            logger.info("Movie found with findByName('/home/inzheneher/Home_along.avi'):");
            logger.info("---------------------------------------------------------------");
            repository.findByMovieName("/home/inzheneher/Home_along.avi").forEach(homeAlong -> logger.info(homeAlong.toString()));
            logger.info("");
        };
    }
}
