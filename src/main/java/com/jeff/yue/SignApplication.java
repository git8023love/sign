package com.jeff.yue;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@ServletComponentScan
@MapperScan("com.jeff.yue.*.dao")
@SpringBootApplication
public class SignApplication {

    private static Logger logger = Logger.getLogger(SignApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SignApplication.class);
        logger.info("Start SignApplication Is Success!");
    }


}
