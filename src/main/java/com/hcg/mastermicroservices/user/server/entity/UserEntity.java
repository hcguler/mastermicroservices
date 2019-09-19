package com.hcg.mastermicroservices.user.server.entity;

import java.io.Serializable;
import java.util.Date;

public class UserEntity implements Serializable {

  private Integer id;
  private String userName;
  private Date createdDate;

  public UserEntity() {
  }

  public UserEntity(Integer id, String userName, Date createdDate) {
    this.id = id;
    this.userName = userName;
    this.createdDate = createdDate;
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
