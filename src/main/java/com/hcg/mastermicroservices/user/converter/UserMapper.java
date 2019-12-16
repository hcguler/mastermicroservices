package com.hcg.mastermicroservices.user.converter;

import com.hcg.mastermicroservices.user.entity.UserEntity;
import com.hcg.mastermicroservices.user.model.UserModel;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author hcguler
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity userModelToUserEntity(UserModel userModel);
    UserModel userEntityToUserModel(UserEntity userEntity);
    List<UserEntity> userModelListToUserEntityList(List<UserModel> userModels);
    List<UserModel> userEntityListToUserModelList(List<UserEntity> userEntities);
}
