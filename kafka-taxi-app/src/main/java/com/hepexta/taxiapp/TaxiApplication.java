package com.hepexta.taxiapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class TaxiApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaxiApplication.class, args);
    }
}
