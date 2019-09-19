package com.hcg.mastermicroservices.user.server.service;

    import com.hcg.mastermicroservices.user.common.model.UserModel;
    import java.util.List;

public interface UserService {

  List<UserModel> getAllUsers();

  UserModel findUserById(Integer id);

  UserModel saveUser(UserModel userModel);

  void deleteUser(Integer id);
}
