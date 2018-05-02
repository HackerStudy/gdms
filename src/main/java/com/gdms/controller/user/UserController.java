package com.gdms.controller.user;

import cc.openkit.common.KitUtil;
import com.alibaba.fastjson.JSONObject;
import com.gdms.model.GLimit;
import com.gdms.service.user.UserService;
import com.gdms.util.StaticFinalVar;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserController {
    private Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView studentinfo(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/user/student");
        return mv;
    }

    @RequestMapping(value = "/teacher", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView teacherinfo(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/user/teacher");
        return mv;
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView addStudent(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/user/addstudent");
        return mv;
    }

    @RequestMapping(value = "/updatestudent", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView updateStudent(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/user/updateStudent");
        return mv;
    }

    @RequestMapping(value = "/delStudent", method = RequestMethod.POST)
    @ResponseBody
    public Object del(HttpServletRequest request){
        Map<String, Object> map = new HashMap<String, Object>();
        String id = request.getParameter("id");
        // 删除
        int i = 1;
        System.out.println("i:"+i);
        map = (i>0)? KitUtil.returnMap("200", StaticFinalVar.DEL_OK):KitUtil.returnMap("101",StaticFinalVar.DEL_ERR);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/lookstudent", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView lookstudentinfo(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/user/lookStudent");
        return mv;
    }
}
