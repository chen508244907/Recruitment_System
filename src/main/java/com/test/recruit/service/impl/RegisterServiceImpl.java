package com.test.recruit.service.impl;

import com.test.recruit.bean.Register;
import com.test.recruit.mapper.RegisterMapper;
import com.test.recruit.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterMapper registerMapper;
    @Override
    public Register findByName(String regName) {
        return registerMapper.selectByPrimaryKey (regName);
    }
}
