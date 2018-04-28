package com.gdms.service.user.impl;

import com.gdms.dao.UserMapper;
import com.gdms.service.user.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
//@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{
    private Logger log = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;
}
