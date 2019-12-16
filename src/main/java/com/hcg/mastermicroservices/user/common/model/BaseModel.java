package com.hcg.mastermicroservices.user.common.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/**
 * @author hcguler
 */

public class BaseModel implements Serializable {

    private Integer id;


    private Date createdDate;

    private Date updatedDate;

    private Integer version;

    @Override
    public boolean equals(Object obj) {
        return obj != null && this.getClass() == obj.getClass() && (obj instanceof BaseModel && (id != null) ? id.equals(((BaseModel) obj).id) : (obj == this));
    }

    @Override
    public int hashCode() {
        return id != null ? this.getClass().hashCode() + id.hashCode() : super.hashCode();
    }
}
