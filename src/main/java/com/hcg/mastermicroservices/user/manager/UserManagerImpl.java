package com.hcg.mastermicroservices.user.manager;

import com.hcg.mastermicroservices.user.converter.UserMapper;
import com.hcg.mastermicroservices.user.entity.UserEntity;
import com.hcg.mastermicroservices.user.exception.UserDoesNotCreateException;
import com.hcg.mastermicroservices.user.exception.UserNotFoundException;
import com.hcg.mastermicroservices.user.model.UserModel;
import com.hcg.mastermicroservices.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Optional;

/**
 * @author hcguler
 */
@Component
public class UserManagerImpl implements UserManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserManagerImpl.class);

    private UserRepository userRepository;

    @Autowired
    public UserManagerImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public UserModel saveUser(UserModel user) {
        try {
            return UserMapper.INSTANCE.userEntityToUserModel(userRepository.save(UserMapper.INSTANCE.userModelToUserEntity(user)));
        } catch (Exception e) {
            LOGGER.error("kayıt oluşturulamadı", e);
            throw new UserDoesNotCreateException(e.getMessage());
        }
    }

    @Override
    public UserModel updateUser(@Valid UserModel user) {
        return UserMapper.INSTANCE.userEntityToUserModel(userRepository.save(UserMapper.INSTANCE.userModelToUserEntity(user)));
    }

    @Override
    public UserModel getUserById(Integer id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isPresent()) {
            return UserMapper.INSTANCE.userEntityToUserModel(optionalUserEntity.get());
        }
        throw new UserNotFoundException("id: " + id);
    }

    @Override
    public UserModel activateUser(@Positive Integer id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            userEntity.setStatus(true);
            return UserMapper.INSTANCE.userEntityToUserModel(userRepository.save(userEntity));
        }
        throw new UserNotFoundException("id=" + id);
    }

    @Override
    public UserModel deacticateUser(@Positive Integer id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isPresent()) {
            UserEntity userEntity = optionalUserEntity.get();
            userEntity.setStatus(false);
            return UserMapper.INSTANCE.userEntityToUserModel(userRepository.save(userEntity));
        }
        throw new UserNotFoundException("id=" + id);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return UserMapper.INSTANCE.userEntityListToUserModelList((List<UserEntity>) userRepository.findAll());
    }

    @Override
    public List<UserModel> getAllActiveUsers() {
        return UserMapper.INSTANCE.userEntityListToUserModelList((List<UserEntity>) userRepository.findAllActiveUsers());
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
