package com.demo.SpringbootRabbitMQ.controller;

import com.demo.SpringbootRabbitMQ.model.Employee;
import com.demo.SpringbootRabbitMQ.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hendrar-rabbitmq")
public class RabbitMQWebController
{
    @Autowired
    private RabbitMQSender rabbitMQSender;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("empName") String empName, @RequestParam("empId") String empId)
    {
        Employee emp = new Employee();
        emp.setEmpId(empId);
        emp.setEmpName(empName);

        rabbitMQSender.send(emp);

        return "MESSAGE HAS BEEN SENT TO THE RABBITMQ";
    }
}
