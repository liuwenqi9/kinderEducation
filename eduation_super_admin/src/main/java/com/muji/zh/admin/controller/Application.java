package com.muji.zh.admin.controller;/**
 * Created by 10347 on 2018/7/11.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * FileName: Application
 * Author:   10347
 * Date:     2018/7/11 15:32
 * Description:
 */
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ImportResource("classpath:consumer.xml")
@ComponentScan("config")
public class Application extends SpringBootServletInitializer {
  public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
  }


}