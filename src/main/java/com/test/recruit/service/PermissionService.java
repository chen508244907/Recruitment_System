package com.test.recruit.service;

import com.test.recruit.bean.Permission;

import java.util.List;

public interface PermissionService{

    public List<Permission> findPermByLoginName(String userName);
}
