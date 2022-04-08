package ru.learnUp.springboottest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import ru.learnUp.springboottest.service.Operation;
import ru.learnUp.springboottest.service.Processor;
import ru.learnUp.springboottest.service.registry.ProcessorRegistry;

import java.util.Map;

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
