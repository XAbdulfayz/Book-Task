package com.library.booktask;

import com.library.booktask.properties.OpenAPIProperties;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@OpenAPIDefinition
@SpringBootApplication
@EnableTransactionManagement
@EnableConfigurationProperties({OpenAPIProperties.class})
public class BookTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookTaskApplication.class, args);
    }

}
