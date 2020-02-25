package com.hcg.mastermicroservices.user.manager;

import com.hcg.mastermicroservices.user.converter.UserMapper;
import com.hcg.mastermicroservices.user.entity.UserEntity;
import com.hcg.mastermicroservices.user.exception.UserNotFoundException;
import com.hcg.mastermicroservices.user.model.UserModel;
import com.hcg.mastermicroservices.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Optional;

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
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isPresent()) {
            return userConverter.userEntityToUserModel(optionalUserEntity.get());
        }
        throw new UserNotFoundException("id: " + id);
    }

    @Override
    public UserModel activateUser(@Positive Integer id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            userEntity.setStatus(true);
            return userConverter.userEntityToUserModel(userRepository.save(userEntity));
        }
        throw new UserNotFoundException("id=" + id);
    }

    @Override
    public UserModel deacticateUser(@Positive Integer id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            userEntity.setStatus(false);
            return userConverter.userEntityToUserModel(userRepository.save(userEntity));
        }
        throw new UserNotFoundException("id=" + id);
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
            userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("id=" + id);
        }
    }
}
