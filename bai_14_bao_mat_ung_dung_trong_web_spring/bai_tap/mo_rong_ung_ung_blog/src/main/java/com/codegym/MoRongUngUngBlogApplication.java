package com.codegym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MoRongUngUngBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoRongUngUngBlogApplication.class, args);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("12345"));
    }

}
