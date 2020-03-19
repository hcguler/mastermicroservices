package com.hcg.mastermicroservices.user.model;

import com.hcg.mastermicroservices.user.common.model.BaseModel;

/**
 * @author hcguler
 */

public class KisiModel extends BaseModel {
    private String ad;
    private String soyad;
    private Integer kisiKayitNo;

    public KisiModel() {
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
