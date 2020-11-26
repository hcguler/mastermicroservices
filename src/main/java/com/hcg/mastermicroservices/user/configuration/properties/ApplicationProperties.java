package com.hcg.mastermicroservices.user.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import static com.hcg.mastermicroservices.user.configuration.constants.ApplicationConfigurationConstants.CLASS_PROPERTIES_PREFIX;

/**
 * bu sınıf application.yml veya application.properties sayfasında yer alan classproperties ifadesinin altındaki değerleri bind etmek için kullanılır.
 */
@Component
@ConfigurationProperties(CLASS_PROPERTIES_PREFIX)
public class ApplicationProperties {
    private int maximum;
    private int minimum;
    private String description;

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
