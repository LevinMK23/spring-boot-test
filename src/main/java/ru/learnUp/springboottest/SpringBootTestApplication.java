package ru.learnUp.springboottest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnUp.springboottest.service.Calculator;
import ru.learnUp.springboottest.service.Operation;
import ru.learnUp.springboottest.service.ValueService;

@SpringBootApplication
public class SpringBootTestApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringBootTestApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootTestApplication.class, args);
        Calculator calculator = context.getBean(Calculator.class);
        log.info("{} - {} = {}", 2, 2, calculator.calculate(2, 2, Operation.MINUS));
        context.getBean(ValueService.class).print();
    }

}
