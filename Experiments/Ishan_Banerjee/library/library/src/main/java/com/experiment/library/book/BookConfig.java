package com.experiment.library.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunner(BookRepository repository) {
        return args -> {
            var it = new Book(1L,
                    "It",
                    "The story follows the experiences of seven children ...",
                    "Horror",
                    LocalDate.of(1986, Month.SEPTEMBER, 15)
            );

            var petSematary = new Book(
                    "Pet Sematary",
                    "Dr. Louis Creed and his wife, Rachel...",
                    "Horror",
                    LocalDate.of(1983, Month.NOVEMBER, 14)
            );

            repository.saveAll(List.of(it, petSematary));
        };
    }
}
