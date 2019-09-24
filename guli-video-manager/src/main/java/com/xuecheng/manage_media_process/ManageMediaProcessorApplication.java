package com.xuecheng.manage_media_process;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


/**
 * @author Administrator
 * @version 1.0
 * @create 2018-07-12 8:57
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ManageMediaProcessorApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageMediaProcessorApplication.class, args);
    }
}
