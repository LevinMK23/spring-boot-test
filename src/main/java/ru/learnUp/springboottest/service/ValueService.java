package ru.learnUp.springboottest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class ValueService {

    private static final Logger log = LoggerFactory.getLogger(ValueService.class);

    private final String value;
    private final Processor sumProcessor;

    public ValueService(
            @Value("${service.value}") String value,
            Processor sumProcessor) {
        this.value = value;
        this.sumProcessor = sumProcessor;
    }

    public void print() {
        log.info("{}", value);
    }
}
