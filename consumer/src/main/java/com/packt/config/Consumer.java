package com.packt.config;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

@Configuration
@EnableRabbit
@RabbitListener(queues = "myQueue")
public class Consumer {
	
	@RabbitHandler
	public void onReceive(@Payload String message) {
		System.out.println("***********************************************");
		System.out.println("Message: " + message);
	}

}
