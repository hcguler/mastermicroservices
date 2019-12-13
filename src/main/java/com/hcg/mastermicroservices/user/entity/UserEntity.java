package com.hcg.mastermicroservices.user.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hcg.mastermicroservices.user.common.entity.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USR_USER")
public class UserEntity extends BaseEntity {
    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @JsonBackReference
    @OneToMany
    @JoinColumn(name = "USER_ID")
    private List<AdresEntity> adresListesi;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "KISI_ID", referencedColumnName = "KISI_KAYIT_NO", foreignKey = @ForeignKey(name = "FK_USER_KISI0"))
    private KisiEntity kisiEntity;

    @Column(name = "STATUS")
    private Boolean status;

    public UserEntity() {
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
