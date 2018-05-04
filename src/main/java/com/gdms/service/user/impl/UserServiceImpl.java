package com.gdms.service.user.impl;

import com.gdms.dao.GGroupLimitMapper;
import com.gdms.dao.UserMapper;
import com.gdms.model.Student;
import com.gdms.model.Teacher;
import com.gdms.service.user.UserService;
import com.gdms.vo.LimitVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{
    private Logger log = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;
    @Resource
    private GGroupLimitMapper gGroupLimitMapper;

    public List<LimitVo> limitgrouplogin(int identityid) {
        return gGroupLimitMapper.getModelByGroupId(identityid);
    }

    public Student selectStudentByid(String username) {
        return userMapper.selectStudentByid(username);
    }

    public Teacher selectTeacherById(String username) {
        return userMapper.selectTeacherById(username);
    }

    public int findIdentityidByTid(String username) {
        return userMapper.findIdentityByTid(username);
    }
}
