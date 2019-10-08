package com.hcg.mastermicroservices.user.repository;

import com.hcg.mastermicroservices.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
}
