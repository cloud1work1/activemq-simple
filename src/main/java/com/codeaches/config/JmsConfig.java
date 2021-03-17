package com.codeaches.config;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class JmsConfig {

	@Value("${spring.activemq.broker-url}")
	private String brokerUrl;
	
	@Bean
	public BrokerService brokerService() throws Exception {
		BrokerService brokerService = new BrokerService();
		brokerService.setPersistent(false);
		brokerService.setUseJmx(true);
		brokerService.addConnector(brokerUrl);
		return brokerService;
	}
	
	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(new PooledConnectionFactory(brokerUrl));
	}
	
	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory connectionFactory = new DefaultJmsListenerContainerFactory();
		connectionFactory.setConnectionFactory(new PooledConnectionFactory(brokerUrl));
		return connectionFactory;
	}
}
