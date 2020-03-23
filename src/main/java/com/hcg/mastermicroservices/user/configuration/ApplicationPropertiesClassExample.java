package com.hcg.mastermicroservices.user.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * bu sınıf application.yml veya application.properties sayfasında yer alan classproperties ifadesinin altındaki değerleri bind etmek için kullanılır.
 */
@Component
@ConfigurationProperties("classproperties")
public class ApplicationPropertiesClassExample {
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
