package com.example.testlinktic;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestLinkticApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestLinkticApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Test Linktic API")
                        .version("1.0.0")
                        .description("Test Linktic API Documentation")
                        .termsOfService("http://swagger.io/terms/"));

    }

}
