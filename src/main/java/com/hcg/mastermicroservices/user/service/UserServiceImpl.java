package com.hcg.mastermicroservices.user.service;


import com.hcg.mastermicroservices.user.manager.UserManager;
import com.hcg.mastermicroservices.user.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hcguler
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserManager userManager;

    @Override
    public UserModel saveUser(UserModel user) {
        return userManager.saveUser(user);
    }

    @Override
    public UserModel getUserById(Integer id) {
        return userManager.getUserById(id);
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
