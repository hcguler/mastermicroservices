package com.hcg.mastermicroservices;

import com.hcg.mastermicroservices.configuration.MasterMicroservicesBootTest;
import com.hcg.mastermicroservices.user.entity.KisiEntity;
import com.hcg.mastermicroservices.user.model.UserModel;
import com.hcg.mastermicroservices.user.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.util.CollectionUtils;

import java.util.List;


public class UserServiceImplTest extends MasterMicroservicesBootTest {
    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationContext applicationContext;

    @Before
    public void init() {
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
        KisiEntity kisiEntity = new KisiEntity();
        kisiEntity.setAd("ad999");
        kisiEntity.setSoyad("soyad999");
        kisiEntity.setKisiKayitNo(999);
        user.setKisiEntity(kisiEntity);
        userService.saveUser(user);
        Assert.assertFalse(CollectionUtils.isEmpty(userService.getAllUsers()));
    }
}
