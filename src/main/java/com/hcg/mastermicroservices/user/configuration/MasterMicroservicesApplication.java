package com.hcg.mastermicroservices.user.configuration;

import com.hcg.mastermicroservices.user.configuration.constants.ApplicationConfigurationConstants;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Map;

@SpringBootApplication
@EntityScan(basePackages = ApplicationConfigurationConstants.BASE_PACKAGES)
@EnableJpaRepositories
public class MasterMicroservicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MasterMicroservicesApplication.class,args);
    }

}
