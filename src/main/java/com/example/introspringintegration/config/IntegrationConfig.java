package com.example.introspringintegration.config;

import com.example.introspringintegration.model.StudentMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.messaging.MessageChannel;

@Configuration
public class IntegrationConfig {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_WHITE = "\u001B[31m";

    @Bean
    public MessageChannel inputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel outputChannel() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow integrationFlow() {
        return IntegrationFlow.from(outputChannel())
                .filter(StudentMessage.class, studentMessage -> studentMessage.getRandomValue() % 2 != 0)
                .handle("messagePrinter", "print")
                .get();
    }

    @Bean
    public MessagePrinter messagePrinter() {
        return new MessagePrinter();
    }

    public static class MessagePrinter {
        public void print(StudentMessage message) {
            System.out.printf("%sReceived message:%s %s%s%s\n",
                    ANSI_GREEN,
                    ANSI_RESET,
                    ANSI_WHITE,
                    message,
                    ANSI_RESET);
        }
    }
}
