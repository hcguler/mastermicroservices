package com.hcg.mastermicroservices.user.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 * @author hcguler
 */

@Configuration
@ComponentScan(basePackages = {"com.hcg.mastermicroservices.user.*"})
@EntityScan(basePackages = {"com.hcg.mastermicroservices.user.*"})
@EnableJpaRepositories(basePackages = {"com.hcg.mastermicroservices.user.*"})
public class MasterMicroservicesConfig {

}