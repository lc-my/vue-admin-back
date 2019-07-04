package com.lc.admin.repository;

import com.lc.admin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @auth liuchong
 * @data 2019-07-03 10:59
 **/
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUserNameAndPassword(String userName, String password);
}
