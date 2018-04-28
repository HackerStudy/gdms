package com.gdms.controller.user;

import com.gdms.service.user.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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

    @RequestMapping(value = "/addstudent", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView addStudent(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/user/addstudent");
        return mv;
    }

    @RequestMapping(value = "/updatestudent", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView updateStudent(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/user/updatestudent");
        return mv;
    }

}
