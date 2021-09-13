package org.aprikhodskiy.otusintegration;

import org.aprikhodskiy.otusintegration.service.TeachingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.integration.annotation.IntegrationComponentScan;

@SpringBootApplication
@IntegrationComponentScan
public class OtusIntegrationApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(OtusIntegrationApplication.class, args);

        TeachingService teachingService = ctx.getBean("teachingService", TeachingService.class);
        teachingService.start();
        ctx.close();
    }
}
