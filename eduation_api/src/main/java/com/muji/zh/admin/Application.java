package com.muji.zh.admin;/**
 * Created by 10347 on 2018/7/11.
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import java.util.concurrent.CountDownLatch;
/**
 * FileName: Application
 * Author:   10347
 * Date:     2018/7/11 15:12
 * Description:
 */
@MapperScan(value = "com.muji.zh.admin.mapper")
@EnableCaching
@SpringBootApplication
public class Application {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Application.class, args).registerShutdownHook();
        countDownLatch.await();
    }

   /*public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }*/

   /* @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        return builder.sources(Application.class);

    }*/
}
