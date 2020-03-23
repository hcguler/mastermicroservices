package com.hcg.mastermicroservices.user.controller;

import com.hcg.mastermicroservices.user.model.UserModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author hcguler
 */
@Validated
public interface AppPropertiesController {
    @GetMapping(value = "/getClassProperties", produces = MediaType.APPLICATION_JSON_VALUE, name = "getTest")
    String getTest();
}
