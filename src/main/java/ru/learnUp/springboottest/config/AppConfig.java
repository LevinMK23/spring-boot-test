package ru.learnUp.springboottest.config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.learnUp.springboottest.service.Operation;
import ru.learnUp.springboottest.service.Processor;
import ru.learnUp.springboottest.service.registry.ProcessorRegistry;

@Configuration
public class AppConfig {

    @Bean
    public ProcessorRegistry processorRegistry(
            Processor sumProcessor,
            Processor subtractProcessor,
            Processor multiplyProcessor
    ) {
        return new ProcessorRegistry(
                Map.of(
                        Operation.PLUS, sumProcessor,
                        Operation.MINUS, subtractProcessor,
                        Operation.MULTIPLY, multiplyProcessor
                )
        );
    }

}
