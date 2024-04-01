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
    private static final String ANSI_RED = "\u001B[31m";

    @Bean
    public MessageChannel inputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel outputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel discardedMessageChannel() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow integrationFlow() {
        return IntegrationFlow.from(outputChannel())
                .filter(StudentMessage.class,
                        studentMessage -> studentMessage.getRandomValue() % 2 != 0,
                        e -> e.discardChannel("discardedMessageChannel"))
                .handle("messagePrinter", "print")
                .get();
    }

    @Bean
    public MessagePrinter messagePrinter() {
        return new MessagePrinter();
    }
    @Bean
    public IntegrationFlow discardedFlow() {
        return IntegrationFlow.from("discardedMessageChannel")
                .handle(message -> {
                    System.out.printf("%sMessage does not satisfy the condition:%s %s\n",
                            ANSI_RED,
                            ANSI_RESET,
                            message.getPayload());
                })
                .get();
    }
    public static class MessagePrinter {
        public void print(StudentMessage message) {
            System.out.printf("%sReceived message:%s %s\n",
                    ANSI_GREEN,
                    ANSI_RESET,
                    message);
        }
    }
}
