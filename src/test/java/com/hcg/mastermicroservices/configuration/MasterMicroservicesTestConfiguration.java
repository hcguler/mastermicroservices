package com.hcg.mastermicroservices.configuration;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;

import static com.hcg.mastermicroservices.user.configuration.constants.ApplicationConfigurationConstants.BASE_PACKAGES;
import static com.hcg.mastermicroservices.user.configuration.constants.ApplicationConfigurationConstants.TEST_PROPERTIES;

@EnableAutoConfiguration
@EntityScan(basePackages = {BASE_PACKAGES})
@ComponentScan(basePackages = {BASE_PACKAGES})
@TestPropertySource(locations = TEST_PROPERTIES)
@EnableJpaRepositories
public class MasterMicroservicesTestConfiguration {
}
