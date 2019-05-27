package com.gdss.onlinevpsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.gdss.onlinevpsystem.mapper")
@SpringBootApplication
@EnableTransactionManagement
public class OnlinevpsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlinevpsystemApplication.class, args);
    }

}
