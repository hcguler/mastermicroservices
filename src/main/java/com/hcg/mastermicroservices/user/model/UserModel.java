package com.hcg.mastermicroservices.user.model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class UserModel implements Serializable {
    private Integer id;

    @NotNull
    private String userName;
    private Date createdDate;

    public UserModel() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
