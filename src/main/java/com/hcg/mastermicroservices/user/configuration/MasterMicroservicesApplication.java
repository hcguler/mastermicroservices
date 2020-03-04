package com.hcg.mastermicroservices.user.configuration;

import com.hcg.mastermicroservices.user.configuration.constants.ApplicationConfigurationConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;
/**
 * @author hcguler
 */

@SpringBootApplication
@EntityScan(basePackages = ApplicationConfigurationConstants.BASE_PACKAGES)
@EnableJpaRepositories
public class MasterMicroservicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MasterMicroservicesApplication.class,args);
    }

    @Bean
    public LocaleResolver localeResolver(){
        SessionLocaleResolver sessionLocaleResolver =  new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.US);
        return sessionLocaleResolver;
    }
}
