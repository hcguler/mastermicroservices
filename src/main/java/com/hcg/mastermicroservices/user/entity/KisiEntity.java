package com.hcg.mastermicroservices.user.entity;

import com.hcg.mastermicroservices.user.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USR_KISI")
public class KisiEntity extends BaseEntity {
    @Column(name = "KISI_AD")
    private String ad;
    @Column(name = "KISI_SOYAD")
    private String soyad;
    @Column(name = "KISI_KAYIT_NO")
    private Integer kisiKayitNo;

    public KisiEntity() {
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public Integer getKisiKayitNo() {
        return kisiKayitNo;
    }

    public void setKisiKayitNo(Integer kisiKayitNo) {
        this.kisiKayitNo = kisiKayitNo;
    }
}
