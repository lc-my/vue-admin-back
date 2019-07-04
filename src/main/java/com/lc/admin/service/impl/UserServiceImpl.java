package com.lc.admin.service.impl;

import com.lc.admin.entity.User;
import com.lc.admin.repository.UserRepository;
import com.lc.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

/**
 * @auth liuchong
 * @data 2019-07-03 11:01
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public void save(User user) {
        if(user.getCreateDate() == null){
            user.setCreateDate(new Date());
        }
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        userRepository.save(user);
    }


    @Override
    public User findById(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User findByUserNameAndPassword(String user, String password) {
        Optional<User> result = userRepository.findByUserNameAndPassword(user, password);
        if(result.isPresent()){
            return result.get();
        }
        return null;
    }

    @Override
    public Page<User> list(int page, int size) {
        Pageable pageable  = PageRequest.of(page-1,size);
        return userRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void remove(long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void batchRemove(Long[] ids) {
        if(ids == null || ids.length == 0){
            return;
        }
        for (Long id : ids) {
            userRepository.deleteById(id);
        }
    }
}
