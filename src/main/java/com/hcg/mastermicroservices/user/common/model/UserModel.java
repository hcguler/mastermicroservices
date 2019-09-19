package com.hcg.mastermicroservices.user.common.model;

import java.io.Serializable;
import java.util.Date;
import org.springframework.stereotype.Component;

public class UserModel implements Serializable {
  private Integer id;
  private String userName;
  private Date createdDate;

  public UserModel() {
    //write for objectMapper
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
