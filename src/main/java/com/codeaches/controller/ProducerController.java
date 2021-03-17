package com.codeaches.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codeaches.service.JmsProducer;

@RestController
@RequestMapping("/jms")
public class ProducerController {

	@Autowired
	private JmsProducer jmsProducer;
	
	@GetMapping
	public void sendToConsumer(@RequestParam String message) {
		jmsProducer.send(message);
	}
}
