package com.demo.SpringbootRabbitMQ.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigPreference
{
    @Value("${rabbitmq.queue}")
    public String queue;

    @Value("{rabbitmq.exchange}")
    public String exchange;

    @Value("{rabbitmq.routingkey}")
    public String routingKey;
}
