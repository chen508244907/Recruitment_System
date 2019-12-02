package com.test.recruit.mapper;

import com.test.recruit.bean.User;
import com.test.recruit.config.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {

    @Select ("SELECT user_name,sex,birthday,email,phone,address  FROM USER  WHERE  user_name = #{user_name}")
    public User findOne(@Param ("user_name") String name);
}
