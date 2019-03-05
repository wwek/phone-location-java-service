package com.iamle.phonelocation;

import com.iamle.phonelocation.controller.PhoneLocationController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PhonelocationApplication {

    public static void main(String[] args) {
        // SpringApplication.run(PhonelocationApplication.class, args);
        SpringApplication.run(PhoneLocationController.class, args);
    }

}
