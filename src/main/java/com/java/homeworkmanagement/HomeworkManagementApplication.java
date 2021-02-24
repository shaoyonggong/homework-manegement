package com.java.homeworkmanagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.java.*"})
public class HomeworkManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeworkManagementApplication.class, args);
    }

}
