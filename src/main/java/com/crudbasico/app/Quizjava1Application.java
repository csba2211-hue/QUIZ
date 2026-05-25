package com.crudbasico.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.crudbasico.app")
public class Quizjava1Application {

    public static void main(String[] args) {
        SpringApplication.run(Quizjava1Application.class, args);
    }

}