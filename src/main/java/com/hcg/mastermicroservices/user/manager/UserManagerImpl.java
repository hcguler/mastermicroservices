package com.hcg.mastermicroservices.user.manager;

import com.hcg.mastermicroservices.user.converter.UserMapper;
import com.hcg.mastermicroservices.user.entity.UserEntity;
import com.hcg.mastermicroservices.user.exception.UserNotFoundException;
import com.hcg.mastermicroservices.user.model.UserModel;
import com.hcg.mastermicroservices.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author hcguler
 */
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
        if (userRepository.findById(id).isPresent()) {
            return userConverter.userEntityToUserModel(userRepository.findById(id).get());
        }
        throw new UserNotFoundException("id: " + id);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userConverter.userEntityListToUserModelList((List<UserEntity>) userRepository.findAll());
    }

    @Override
    public List<UserModel> getAllActiveUsers() {
        return userConverter.userEntityListToUserModelList((List<UserEntity>) userRepository.findAllActiveUsers());
    }

    @Override
    public void deleteUser(Integer id) {
        if (userRepository.findById(id).isPresent()) {
            UserEntity userEntity = userRepository.findById(id).get();
            userRepository.delete(userEntity);
        }
        throw new UserNotFoundException("id=" + id);
    }
}
