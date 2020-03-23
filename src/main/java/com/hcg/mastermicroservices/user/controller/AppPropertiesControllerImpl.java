package com.hcg.mastermicroservices.user.controller;

import com.hcg.mastermicroservices.user.configuration.ApplicationPropertiesClassExample;
import com.hcg.mastermicroservices.user.model.UserModel;
import com.hcg.mastermicroservices.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author hcguler
 */
@RestController
@RequestMapping(path = "/appproperties")
public class AppPropertiesControllerImpl implements AppPropertiesController {

    @Autowired
    ApplicationPropertiesClassExample applicationPropertiesClassExample;

    @Override
    public String getTest() {
        StringBuilder  stringBuilder = new StringBuilder("\nMaximum: ")
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
