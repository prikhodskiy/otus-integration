package org.aprikhodskiy.otusintegration.integration;

import org.aprikhodskiy.otusintegration.domain.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class TeachingFlowConfiguration {
    @Bean
    public MessageChannel courseChannel() {
        return new DirectChannel();
    }

    @MessagingGateway
    public interface OtusCourse {
        @Gateway(requestChannel = "courseChannel")
        Collection<Employee> make(Collection<Employee> employees);
    }

    @Bean
    public IntegrationFlow teachingFlow() {
        return IntegrationFlows.from("courseChannel")
                .wireTap(f -> f.handle(t -> System.out.println("Before OTUS course")))
                .split()
                .handle("appraisalReview", "review")
                .aggregate()
                .handle("otusTeacher", "teach")
                .wireTap(f -> f.handle(t -> System.out.println("After OTUS course")))
                .split()
                .handle("appraisalReview", "review")
                .get();
    }
}
