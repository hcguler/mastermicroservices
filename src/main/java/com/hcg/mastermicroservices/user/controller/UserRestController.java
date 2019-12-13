package com.hcg.mastermicroservices.user.controller;

import com.hcg.mastermicroservices.user.exception.UserNotFoundException;
import com.hcg.mastermicroservices.user.model.UserModel;
import com.hcg.mastermicroservices.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(path = "/user")
public class UserRestController implements UserRestService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    private UserService userService;

    @Override
    public UserModel getUser(@PathVariable Integer id) {
        UserModel user = userService.getUserById(id);
        if (Objects.isNull(user))
            throw new UserNotFoundException("id: " + id);
        return user;
    }
    @Override
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public List<UserModel> getAllActiveUsers() {
        return userService.getAllActiveUsers();
    }

    @Override
    public ResponseEntity<UserModel> saveUser(@RequestBody UserModel userModel) {
        UserModel savedModel = userService.saveUser(userModel);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedModel)
                .toUri();
        return ResponseEntity.created(location).build();
    }
    @Override
    public Map<String, Boolean> deleteUser(Integer id) {
        userService.deleteUser(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
