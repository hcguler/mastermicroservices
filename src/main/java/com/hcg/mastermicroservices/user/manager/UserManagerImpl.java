package com.hcg.mastermicroservices.user.manager;

import com.hcg.mastermicroservices.user.converter.UserMapper;
import com.hcg.mastermicroservices.user.entity.UserEntity;
import com.hcg.mastermicroservices.user.model.UserModel;
import com.hcg.mastermicroservices.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserManagerImpl implements UserManager {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userConverter;

    @Override
    public UserModel saveUser(UserModel user) {
        return userConverter.userEntityToUserModel(userRepository.save(userConverter.userModelToUserEntity(user)));
    }

    @Override
    public UserModel getUserById(Integer id) {
        return userConverter.userEntityToUserModel(userRepository.findById(id).get());
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userConverter.userEntityListToUserModelList((List<UserEntity>) userRepository.findAll());
    }

    @Override
    public void deleteUser(Integer id) {
        UserEntity userEntity = userRepository.findById(id).get();
        userRepository.delete(userEntity);
    }
}
