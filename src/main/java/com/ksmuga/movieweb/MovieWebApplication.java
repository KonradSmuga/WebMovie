package com.ksmuga.movieweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.UnknownHostException;

@SpringBootApplication
public class MovieWebApplication {

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(MovieWebApplication.class);
        Environment env = app.run(args).getEnvironment();

    }
}
