package com.logistics.manage;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.logistics.manage.mapper")
public class LogisticsmanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogisticsmanageApplication.class, args);
    }

}
