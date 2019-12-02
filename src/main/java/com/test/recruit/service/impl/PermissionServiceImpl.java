package com.test.recruit.service.impl;

import com.test.recruit.bean.Permission;
import com.test.recruit.mapper.PermissionMapper;
import com.test.recruit.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override/*根据登录名查询该用户所拥有的权限*/
    public List<Permission> findPermByLoginName(String userName){
        return permissionMapper.selectByExample (userName);
    }
}
