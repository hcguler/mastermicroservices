package com.hcg.mastermicroservices.user.repository;

import com.hcg.mastermicroservices.user.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author hcguler
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    @Query(
            value = "SELECT * FROM USR_USER u WHERE u.status = true ",
            nativeQuery = true)
    Collection<UserEntity> findAllActiveUsers();
}
