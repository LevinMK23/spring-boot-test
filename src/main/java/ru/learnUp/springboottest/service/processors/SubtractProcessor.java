package ru.learnUp.springboottest.service.processors;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.learnUp.springboottest.service.Operation;
import ru.learnUp.springboottest.service.Processor;

@Component
@Profile("testing")
public class SubtractProcessor implements Processor {

    @Override
    public Operation getOperation() {
        return Operation.MINUS;
    }

    @Override
    public int process(int a, int b) {
        return a - b;
    }
}
