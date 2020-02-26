package com.hcg.mastermicroservices.user.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author hcguler
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {


    public static final Contact DEFAULT_CONTACT = new Contact("Hüseyin Cihad GÜLER", "http://www.hcguler.com", "cihad_guler@hotmail.com");
    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Master Microservices Eğitim Uygulaması", "Udemy'den alınan mastermicroservices kapsamında yapılan geliştirmeleri içermektedir.",
            "1.0", "urn:tos",
            DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());


    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO);
    }

}
