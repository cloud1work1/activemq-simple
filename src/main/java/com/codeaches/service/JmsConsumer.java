package com.codeaches.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class JmsConsumer {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@JmsListener(destination = "${spring.activemq.queue.name}")
	public void receivedMessage(String message) {
		logger.info("Received Message: {}", message);
	}
}
