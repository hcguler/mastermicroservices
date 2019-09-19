package com.hcg.mastermicroservices.user.server.service;

import com.hcg.mastermicroservices.user.common.model.UserModel;
import com.hcg.mastermicroservices.user.server.manager.UserManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//wirite yr logic and exception handling
@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserManager userManager;

  @Override
  public List<UserModel> getAllUsers() {
    return userManager.getAllUsers();
  }

  @Override
  public UserModel findUserById(Integer id) {
    return userManager.findUserById(id);
  }

  @Override
  public UserModel saveUser(UserModel userModel) {
    return userManager.saveUser(userModel);
  }

  @Override
  public void deleteUser(Integer id) {
    userManager.deleteUser(id);
  }
}
