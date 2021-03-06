package com.hcg.mastermicroservices;

import com.hcg.mastermicroservices.configuration.MasterMicroservicesBootTest;
import com.hcg.mastermicroservices.user.configuration.context.ApplicationContextHolder;
import com.hcg.mastermicroservices.user.model.KisiModel;
import com.hcg.mastermicroservices.user.model.UserModel;
import com.hcg.mastermicroservices.user.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.util.CollectionUtils;

import java.util.List;


public class UserServiceImplTest extends MasterMicroservicesBootTest {

    private final UserService userService;

    public UserServiceImplTest(UserService userService) {
        this.userService = userService;
    }

    @Before
    public void init() {
        ApplicationContext applicationContext = ApplicationContextHolder.getApplicationContext();
        String[] beans = applicationContext.getBeanDefinitionNames();
        /*for (String bean : beans) {
            System.out.println("-------------------" + bean);
        }*/
    }

    @Test
    public void userSaveTest() {
        //todo sequence baştan başlıyor düzenlenmeli.
        List<UserModel> allUsers = userService.getAllUsers();
        for (UserModel userModel : allUsers) {
            userService.deleteUser(userModel.getId());
        }

        UserModel user = new UserModel();
        user.setUserName("username999");
        user.setPassword("password999");
        KisiModel kisiModel = new KisiModel();
        kisiModel.setAd("ad999");
        kisiModel.setSoyad("soyad999");
        kisiModel.setKisiKayitNo(999);
        user.setKisiModel(kisiModel);
        userService.saveUser(user);
        Assert.assertFalse(CollectionUtils.isEmpty(userService.getAllUsers()));
    }
}
