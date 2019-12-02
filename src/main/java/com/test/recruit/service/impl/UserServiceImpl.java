package com.test.recruit.service.impl;

import com.test.recruit.bean.User;
import com.test.recruit.mapper.UserMapper;
import com.test.recruit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByName(String name) {
        User user=userMapper.findOne (name);
        return user;
    }
}
