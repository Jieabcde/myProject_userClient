package com.example.bishe_;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j //log注解
@SpringBootApplication
@ServletComponentScan //扫描WebFilter注解及过滤器注解
@EnableTransactionManagement //开启事务支持，加了此注解，代表开启事务。 一般业务涉及2个表以上的都要开启事务注解  SpringBoot默认开启
public class BiSheApplication {

    public static void main(String[] args) {
        SpringApplication.run(BiSheApplication.class, args);
        log.info("项目启动成功");
    }

}
