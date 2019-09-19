package com.hcg.mastermicroservices.user.common.controller;

import com.hcg.mastermicroservices.user.common.model.UserModel;
import com.hcg.mastermicroservices.user.server.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRestController {

  @Autowired
  private UserService userService;


  @GetMapping(path = "/getAllUsers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public List<UserModel> getAllUsers() {
    return userService.getAllUsers();
  }
  @PostMapping(path = "/saveUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public UserModel getAllUsers(@RequestBody UserModel userModel) {
    return userService.saveUser(userModel);
  }
}
