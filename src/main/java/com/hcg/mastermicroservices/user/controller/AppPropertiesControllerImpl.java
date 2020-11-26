package com.hcg.mastermicroservices.user.controller;

import com.hcg.mastermicroservices.user.configuration.properties.ApplicationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hcguler
 */
@RestController
@RequestMapping(path = "/appproperties")
public class AppPropertiesControllerImpl implements AppPropertiesController {

    private final ApplicationProperties applicationPropertiesClassExample;

    public AppPropertiesControllerImpl(ApplicationProperties applicationPropertiesClassExample) {
        this.applicationPropertiesClassExample = applicationPropertiesClassExample;
    }

    @Override
    public String getTest() {
        StringBuilder stringBuilder = new StringBuilder("\nMaximum: ")
                .append(applicationPropertiesClassExample.getMaximum())
                .append("\n")
                .append("Minimum: ")
                .append(applicationPropertiesClassExample.getMinimum())
                .append("\n")
                .append("Description: ")
                .append(applicationPropertiesClassExample.getDescription());
        return stringBuilder.toString();
    }
}
