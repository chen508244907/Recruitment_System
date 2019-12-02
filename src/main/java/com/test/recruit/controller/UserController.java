package com.test.recruit.controller;

import com.test.recruit.bean.User;
import com.test.recruit.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    public static final Logger logger= LogManager.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findOne",method = RequestMethod.GET)
    public User findOneByName(String name){
        logger.info (name+"===============================");
        User user = userService.findByName ("张三");
        logger.info (user);
        return user;
    }
}
