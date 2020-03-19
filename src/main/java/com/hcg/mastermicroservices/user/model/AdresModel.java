package com.hcg.mastermicroservices.user.model;

import com.hcg.mastermicroservices.user.common.model.BaseModel;

public class AdresModel extends BaseModel {

    private String il;
    private String ilce;

    public AdresModel() {
    }

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }
}
