package ru.learnUp.springboottest.service.registry;

import java.util.Map;

import ru.learnUp.springboottest.service.Operation;
import ru.learnUp.springboottest.service.Processor;


public class ProcessorRegistry {

    private final Map<Operation, Processor> registry;

    public ProcessorRegistry(Map<Operation, Processor> registry) {
        this.registry = registry;
    }

    public Processor findByType(Operation operation) {
        if (!registry.containsKey(operation)) {
            throw new RuntimeException("Unknown operation");
        }
        return registry.get(operation);
    }
}
