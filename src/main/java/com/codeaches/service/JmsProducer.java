package com.codeaches.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsProducer {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Value("${spring.activemq.queue.name}")
	private String queueName;
	
	public void send(String message) {
		jmsTemplate.convertAndSend(queueName, message);
		logger.info("Sent Message: {}", message);
	}
}
