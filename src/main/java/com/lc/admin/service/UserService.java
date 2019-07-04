package com.lc.admin.service;

import com.lc.admin.entity.User;
import org.springframework.data.domain.Page;

/**
 * @auth liuchong
 * @data 2019-07-03 11:01
 **/
public interface UserService {

    void save(User user);

    void update(User user);

    User findById(long id);

    User findByUserNameAndPassword(String user,String password);

    Page<User> list(int page,int size);

    void remove(long id);

    void batchRemove(Long[] ids);


}
