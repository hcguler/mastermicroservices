package com.hcg.mastermicroservices.user.common.entity;

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

@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;


    @Column(name = "CREATED_DATE", nullable = false)
    @CreatedDate
    @CreationTimestamp
    private Date createdDate;

    @Column(name = "UPDATED_DATE", nullable = false)
    @LastModifiedDate
    @UpdateTimestamp
    private Date updatedDate;

    @Version
    @Column(name = "OBJ_VERSION")
    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && this.getClass() == obj.getClass() && (obj instanceof BaseEntity && (id != null) ? id.equals(((BaseEntity) obj).id) : (obj == this));
    }

    @Override
    public int hashCode() {
        return id != null ? this.getClass().hashCode() + id.hashCode() : super.hashCode();
    }
}
