package com.techbow.microservices.dataprocessor;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by guang on 11:42 AM 8/18/18.
 */
@SpringBootApplication(scanBasePackages = "com.techbow.microservices")
@EnableDiscoveryClient
@EnableRabbit
@EnableJpaRepositories(basePackages={"com.techbow.microservices.common.model.dao"})
@EntityScan(basePackages={"com.techbow.microservices.common.model.dvo"})
public class DataProcessorApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataProcessorApplication.class, args);
    }
}
