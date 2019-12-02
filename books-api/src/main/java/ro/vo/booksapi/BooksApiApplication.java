package ro.vo.booksapi;

import io.swagger.configuration.JacksonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Configuration
@Import(JacksonConfiguration.class)
public class BooksApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksApiApplication.class, args);
    }
}
