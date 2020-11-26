package com.hcg.mastermicroservices.user.configuration.context;

import org.springframework.beans.BeansException;
import org.springframework.context.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * context üzerindeki bean erişimi ve environment değerlere erişim için ApplicationContext'in static hizmet verdiği sınıftır.
 */
@Configuration
public class ApplicationContextHolder implements ApplicationContextInitializer<ConfigurableApplicationContext>, ApplicationContextAware {
    private static ApplicationContext applicationContext;

    private static Environment environment;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        try {
            if (applicationContext instanceof XmlWebApplicationContext) {
                prepareContextBean(applicationContext);
            }
        } catch (Exception e) {
            throw new ApplicationContextException(e.getMessage(), e);
        }
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        try {
            if (GenericWebApplicationContext.class.isAssignableFrom(applicationContext.getClass())) {
                prepareContextBean(applicationContext);
            }
        } catch (Exception e) {
            throw new ApplicationContextException(e.getMessage(), e);
        }
    }

    public static <T> T getBean(String beanName) {
        return (T) applicationContext.getBean(beanName);
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    private synchronized void prepareContextBean(ApplicationContext applicationContext) {
        ApplicationContextHolder.applicationContext = applicationContext;
        ApplicationContextHolder.environment = applicationContext.getEnvironment();
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Environment getEnvironment() {
        return environment;
    }

}
