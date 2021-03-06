package com.hcg.mastermicroservices.user.service;


import com.hcg.mastermicroservices.user.manager.UserManager;
import com.hcg.mastermicroservices.user.model.UserModel;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

/**
 * @author hcguler
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserManager userManager;

    public UserServiceImpl(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public UserModel saveUser(UserModel user) {
        return userManager.saveUser(user);
    }

    @Override
    public UserModel updateUser(@Valid UserModel user) {
        return userManager.updateUser(user);
    }

    @Override
    public UserModel getUserById(Integer id) {
        return userManager.getUserById(id);
    }

    @Override
    public UserModel activateUser(@Positive Integer id) {
        return userManager.activateUser(id);
    }

    @Override
    public UserModel deacticateUser(@Positive Integer id) {
        return userManager.deacticateUser(id);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userManager.getAllUsers();
    }

    @Override
    public List<UserModel> getAllActiveUsers() {
        return userManager.getAllActiveUsers();
    }

    @Override
    public void deleteUser(Integer id) {
        userManager.deleteUser(id);
    }
}
