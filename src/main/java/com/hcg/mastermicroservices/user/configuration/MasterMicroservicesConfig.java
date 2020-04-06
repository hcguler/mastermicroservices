package com.hcg.mastermicroservices.user.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static com.hcg.mastermicroservices.user.configuration.constants.ApplicationConfigurationConstants.BASE_PACKAGES;

/**
 * @author hcguler
 */

@Configuration
@ComponentScan(basePackages = {BASE_PACKAGES})
@EntityScan(basePackages = {BASE_PACKAGES})
@EnableJpaRepositories(basePackages = {BASE_PACKAGES})
public class MasterMicroservicesConfig {
}