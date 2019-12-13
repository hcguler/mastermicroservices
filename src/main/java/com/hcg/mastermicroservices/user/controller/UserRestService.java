package com.hcg.mastermicroservices.user.controller;

import com.hcg.mastermicroservices.user.model.UserModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Map;

@Validated
public interface UserRestService {
    @GetMapping(value = "/getUser/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, name = "getUsers")
    UserModel getUser(@PathVariable Integer id);

    @GetMapping(value = "/getAllUsers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, name = "getAllUsers")
    List<UserModel> getAllUsers();

    @GetMapping(value = "/getAllActiveUsers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, name = "getAllActiveUsers")
    List<UserModel> getAllActiveUsers();

    @PostMapping(value = "/save/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, name = "saveUser")
    ResponseEntity<UserModel> saveUser(@Valid @RequestBody UserModel userModel);

    @DeleteMapping(value = "/delete/user/{id}")
    Map<String, Boolean> deleteUser(@Positive @PathVariable Integer id);
}
