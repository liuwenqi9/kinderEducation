package com.muji.uml;


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
@ImportResource("classpath:/generatorConfig.xml")
public class Application {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Application.class, args).registerShutdownHook();
        countDownLatch.await();
    }





   /* @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        return builder.sources(Application.class);

    }*/
}