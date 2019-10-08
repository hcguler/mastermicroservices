package com.hcg.mastermicroservices.user.manager;

import com.hcg.mastermicroservices.user.entity.UserEntity;
import com.hcg.mastermicroservices.user.model.UserModel;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

public interface UserManager {
    UserModel saveUser(@Valid UserModel user);
    UserModel getUserById(@Positive Integer id);
    List<UserModel> getAllUsers();
    void deleteUser(@Positive Integer id);
}
