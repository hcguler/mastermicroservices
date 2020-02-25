package com.hcg.mastermicroservices.user.manager;

import com.hcg.mastermicroservices.user.entity.UserEntity;
import com.hcg.mastermicroservices.user.model.UserModel;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

/**
 * @author hcguler
 */
public interface UserManager {
    UserModel saveUser(@Valid UserModel user);
    UserModel getUserById(@Positive Integer id);
    UserModel activateUser(@Positive Integer id);
    UserModel deacticateUser(@Positive Integer id);
    List<UserModel> getAllUsers();
    List<UserModel> getAllActiveUsers();
    void deleteUser(@Positive Integer id);
}
