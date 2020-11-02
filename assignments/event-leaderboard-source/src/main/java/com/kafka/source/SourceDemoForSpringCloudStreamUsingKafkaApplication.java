package com.kafka.source;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
public class SourceDemoForSpringCloudStreamUsingKafkaApplication {
	public static void main(String[] args) {
		SpringApplication.run(SourceDemoForSpringCloudStreamUsingKafkaApplication.class, args);
	}
}
