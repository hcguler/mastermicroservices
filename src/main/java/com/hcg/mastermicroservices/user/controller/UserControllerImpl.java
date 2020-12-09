package com.hcg.mastermicroservices.user.controller;

import com.hcg.mastermicroservices.user.configuration.context.ApplicationContextHolder;
import com.hcg.mastermicroservices.user.configuration.properties.ApplicationProperties;
import com.hcg.mastermicroservices.user.model.UserModel;
import com.hcg.mastermicroservices.user.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final UserService userService;

    private final MessageSource messageSource;

    public UserControllerImpl(UserService userService, MessageSource messageSource) {
        this.userService = userService;
        this.messageSource = messageSource;
    }

    @Override
    public String getTest(Locale locale) {
        ApplicationProperties applicationProperties = ApplicationContextHolder.getBean(ApplicationProperties.class);
        LOGGER.debug("ContextHolder üzerinden static olarak bean çekip değerleri okuma örneği: " + applicationProperties.getDescription());
        return messageSource.getMessage("hello", null, locale);
    }

    @Override
    public Map<String, String> getZipTest(Locale locale) {
        ApplicationProperties applicationProperties = ApplicationContextHolder.getBean(ApplicationProperties.class);
        LOGGER.debug("ContextHolder üzerinden static olarak bean çekip değerleri okuma örneği: " + applicationProperties.getDescription());
        String key = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        Map<String, String> filters = new HashMap<>();
        for (int i = 0; i < 400000; i++) {
            filters.put(RandomStringUtils.random(20, true, true), RandomStringUtils.random(40, true, true));
        }
        return filters;
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
