package com.hcg.mastermicroservices.user.controller;

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
@RequestMapping(path = "/user")
public class UserControllerImpl implements UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserControllerImpl.class);

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSource messageSource;

    @Override
    public String getTest(Locale locale) {
        return messageSource.getMessage("hello",null, locale);
    }

    @Override
    public UserModel getUser(@PathVariable Integer id) {
        LOGGER.debug(id + " numaralı id bilgisine sahip kullanıcı sorgulandı..");
        return userService.getUserById(id);
    }

    @Override
    public List<UserModel> getAllUsers() {
        LOGGER.debug("Tüm kullanıcılar sorgulandı.");
        return userService.getAllUsers();
    }

    @Override
    public List<UserModel> getAllActiveUsers() {
        LOGGER.debug("Tüm aktif kullanıcılar sorgulandı.");
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
        LOGGER.debug("Yeni kullanıcı eklendi.");
        return ResponseEntity.created(location).body(savedModel);
    }

    @Override
    public ResponseEntity<UserModel> updateUser(@Valid UserModel userModel) {
        UserModel savedModel = userService.updateUser(userModel);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedModel)
                .toUri();
        LOGGER.debug("Yeni kullanıcı eklendi.");
        return ResponseEntity.created(location).body(savedModel);
    }

    @Override
    public ResponseEntity<UserModel> activateUser(Integer id) {
        UserModel savedModel = userService.activateUser(id);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedModel)
                .toUri();
        LOGGER.debug(id + " numaralı id bilgisine sahip kullanıcı aktif edildi.");
        return ResponseEntity.created(location).body(savedModel);
    }

    @Override
    public ResponseEntity<UserModel> deacticateUser(Integer id) {
        UserModel savedModel = userService.deacticateUser(id);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedModel)
                .toUri();
        LOGGER.debug(id + " numaralı id bilgisine sahip kullanıcı pasif edildi.");
        return ResponseEntity.created(location).body(savedModel);
    }

    @Override
    public Map<String, Boolean> deleteUser(Integer id) {
        userService.deleteUser(id);
        Map<String, Boolean> response = new HashMap<>(1);
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
