package com.hcg.mastermicroservices.user.entity;

import com.hcg.mastermicroservices.user.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author hcguler
 */

@Entity
@Table(name = "USR_ADRES")
public class AdresEntity  extends BaseEntity {
    @Column(name = "ADRES_IL")
    private String il;
    @Column(name = "ADRES_ILCE")
    private String ilce;

    public AdresEntity() {
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
