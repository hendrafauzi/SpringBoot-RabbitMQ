package com.demo.SpringbootRabbitMQ.service;

import com.demo.SpringbootRabbitMQ.config.ConfigPreference;
import com.demo.SpringbootRabbitMQ.model.Employee;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender
{
    private ConfigPreference preference;
    private AmqpTemplate amqpTemplate;

    @Autowired
    public RabbitMQSender(ConfigPreference preference, AmqpTemplate amqpTemplate)
    {
        this.preference = preference;
        this.amqpTemplate = amqpTemplate;
    }

    public void send(Employee employee)
    {
        amqpTemplate.convertAndSend(preference.exchange, preference.routingKey, employee);
        System.out.println("Send Message: " + employee);
    }
}