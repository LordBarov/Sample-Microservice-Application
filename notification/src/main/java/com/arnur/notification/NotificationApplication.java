package com.arnur.notification;

import com.arnur.amqp.RabbitMQMessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import javax.management.Notification;

@SpringBootApplication(
        scanBasePackages = {
                "com.arnur.notification",
                "com.arnur.amqp"
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.arnur.clients"
)
public class NotificationApplication {


    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(RabbitMQMessageProducer rabbitMQMessageProducer, NotificationConfig notificationConfig) {
//        return args -> {
//            rabbitMQMessageProducer.publish(new Person("Ali", 18), notificationConfig.getInternalExchange(), notificationConfig.getInternalNotificationRoutingKey());
//        };
//    }
//
//    record Person(String name, int age) {
//
//    }
}
