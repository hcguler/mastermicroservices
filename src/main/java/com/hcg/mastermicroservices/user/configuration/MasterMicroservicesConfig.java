package com.hcg.mastermicroservices.user.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Map;
/**
 * @author hcguler
 */

@Configuration
@ComponentScan(basePackages = {"com.hcg.mastermicroservices.user.*"})
@EntityScan(basePackages = {"com.hcg.mastermicroservices.user.*"})
@EnableJpaRepositories(basePackages = {"com.hcg.mastermicroservices.user.*"})
public class MasterMicroservicesConfig {

}