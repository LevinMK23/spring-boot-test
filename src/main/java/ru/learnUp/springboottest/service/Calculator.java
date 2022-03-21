package ru.learnUp.springboottest.service;

import org.springframework.stereotype.Service;
import ru.learnUp.springboottest.service.registry.ProcessorRegistry;

@Service
public class Calculator {

    private final ProcessorRegistry registry;

    public Calculator(ProcessorRegistry registry) {
        this.registry = registry;
    }

    @Calculable
    public int calculate(int a, int b, Operation operation) {
        return registry.findByType(operation).process(a, b);
    }

}
