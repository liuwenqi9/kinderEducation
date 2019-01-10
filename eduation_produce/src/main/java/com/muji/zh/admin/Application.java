package com.muji.zh.admin;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;

import java.util.concurrent.CountDownLatch;

/**
 * FileName: Application
 * Author:   10347
 * Date:     2018/7/11 15:12
 * Description:
 */
@MapperScan("com.muji.zh.admin.mapper")
@EnableCaching
@SpringBootApplication
@ImportResource("classpath:/static/provider.xml")
public class  Application {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(com.muji.zh.admin.Application.class, args).registerShutdownHook();
        countDownLatch.await();
    }

    
}
