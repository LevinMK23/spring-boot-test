package ru.learnUp.springboottest.service.processors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.learnUp.springboottest.service.Operation;
import ru.learnUp.springboottest.service.Processor;

@Qualifier("multiplyProcessor")
@Component
public class MultiplyProcessor implements Processor {

    @Override
    public Operation getOperation() {
        return Operation.MULTIPLY;
    }

    @Override
    public int process(int a, int b) {
        return a * b;
    }
}
