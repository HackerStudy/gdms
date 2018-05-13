package com.gdms.test;

import com.gdms.model.Major;
import com.gdms.service.user.MajorService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;

public class UserControllerTest {
    @Resource
    MajorService majorService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addStudent() {
        // 获取分组名字
        Integer did =Integer.valueOf(6);
        Integer mid =1;
        System.out.println("did:"+did+"      mid:"+mid);
        Major major=majorService.queryMajorByMid(mid);
            if (did==major.getDid()) {
                System.out.println("成功");
            }else{
                System.out.println("错误");
            }
    }
}