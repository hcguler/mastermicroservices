package com.hcg.mastermicroservices.user.model;

import com.hcg.mastermicroservices.user.common.model.BaseModel;
import com.hcg.mastermicroservices.user.entity.AdresEntity;
import com.hcg.mastermicroservices.user.entity.KisiEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author hcguler
 */
public class UserModel extends BaseModel {
    @NotNull
    @Size(max = 50)
    private String userName;

    @NotNull
    @Size(max = 25)
    private String password;

    private List<AdresEntity> adresListesi;

    @NotNull
    private KisiEntity kisiEntity;

    private Boolean status;

    public UserModel() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<AdresEntity> getAdresListesi() {
        return adresListesi;
    }

    public void setAdresListesi(List<AdresEntity> adresListesi) {
        this.adresListesi = adresListesi;
    }

    public KisiEntity getKisiEntity() {
        return kisiEntity;
    }

    public void setKisiEntity(KisiEntity kisiEntity) {
        this.kisiEntity = kisiEntity;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
