package com.codegym.repository;

import com.codegym.dto.ContractDetailDTO;
import com.codegym.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    @Transactional
    @Modifying
    @Query(value="INSERT INTO user_role(user_id,role_id) VALUE (:userId,:roleId)",nativeQuery = true)
    void addUserRole(@Param("userId")long userId, @Param("roleId")long roleId);

    @Transactional
    @Modifying
    @Query(value="INSERT INTO user_role(user_id,role_id) VALUE (:userId,:roleId),(:userId,:roleId2)",nativeQuery = true)
    void addUserRole2(@Param("userId")long userId, @Param("roleId")long roleId,@Param("roleId2")long roleId2);

}
