package com.packt.web;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@RequestMapping(value = "/publish", method = RequestMethod.GET)
	public void publish(@RequestParam String message) {
		rabbitTemplate.convertAndSend("myQueue", message);
	}
	
	@RequestMapping(value = "/vcap", method = RequestMethod.GET)
	public String vcap() {
		return System.getenv("VCAP_SERVICES");
	}

}
