package com.clothing.manage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.clothing.manage.dao")
@EnableSwagger2
public class ClothingManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClothingManageApplication.class, args);
    }
}
