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
public interface UserController {
    @GetMapping(value = "/getTest", produces = MediaType.APPLICATION_JSON_VALUE, name = "getTest")
    String getTest(@RequestHeader(name = "Accept-Language", required = false) Locale locale);

    @GetMapping(value = "/getUser/{id}", produces = MediaType.APPLICATION_JSON_VALUE, name = "getUsers")
    UserModel getUser(@PathVariable Integer id);

    @GetMapping(value = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE, name = "getAllUsers")
    List<UserModel> getAllUsers();

    @GetMapping(value = "/getAllActiveUsers", produces = MediaType.APPLICATION_JSON_VALUE, name = "getAllActiveUsers")
    List<UserModel> getAllActiveUsers();

    @PostMapping(value = "/save/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, name = "saveUser")
    ResponseEntity<UserModel> saveUser(@Valid @RequestBody UserModel userModel);

    @PutMapping(value = "/update/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, name = "updateUser")
    ResponseEntity<UserModel> updateUser(@Valid @RequestBody UserModel userModel);

    @PutMapping(value = "/activateUser/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, name = "acticateUser")
    ResponseEntity<UserModel> activateUser(@PathVariable Integer id);

    @PutMapping(value = "/deacticateUser/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, name = "deacticateUser")
    ResponseEntity<UserModel> deacticateUser(@PathVariable Integer id);

    @DeleteMapping(value = "/delete/user/{id}")
    Map<String, Boolean> deleteUser(@Positive @PathVariable Integer id);
}
