package com.gdms.controller.user;

import com.gdms.model.*;
import com.gdms.service.admin.AdminService;
import com.gdms.service.notice.NoticeService;
import com.gdms.service.user.UserService;
import com.gdms.util.StaticFinalVar;
import com.gdms.util.StringAndDate;
import com.gdms.vo.LimitVo;
import com.gdms.vo.NoticeVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
    @Resource
    AdminService adminService;
    @Resource
    UserService userService;

    @Resource
    NoticeService noticeService;


    @RequestMapping(value ="/goLogin", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goLogin(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/login");
        return mv;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, HttpSession session){
        ModelAndView modelAndView=new ModelAndView();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        List<Notice> noticeList=noticeService.queryAllNotice();
        List<NoticeVo> noticeVoList=new ArrayList<NoticeVo>();
        for (Notice list:noticeList) {
            NoticeVo noticeVo=new NoticeVo(list.getId(),list.getTitle(), StringAndDate.dateToString(list.getTime()),list.getUrl());
            noticeVoList.add(noticeVo);
        }
        session.setAttribute("noticeVoList",noticeVoList);
        int identityid=Integer.valueOf(request.getParameter("identityid"));
//        System.out.println("现在开始登录");
        if(identityid==1||identityid==5){
            Admin admin = new Admin();
            admin.setKitAdminUsername(username);
            admin.setKitAdminPassword(password);
            Admin returnAdmin = adminService.getModelByUsernameAndPassword(admin);
            if(returnAdmin==null){
                // 如果为空，跳转到登录页面
                modelAndView.setViewName("/view/login");
                modelAndView.addObject("msg", StaticFinalVar.USERNAME_OR_PWD_ERR);
                return modelAndView;
            }else{
                User user=new User(username,password,identityid);
                session.setAttribute("user",user);
                session.setAttribute("admin",returnAdmin);
                List<LimitVo> limitVoList=userService.limitgrouplogin(identityid);
                session.setAttribute("limitList",limitVoList);
//                System.out.println("现在开始跳转到主页面");
                modelAndView.setViewName("/view/index");
                return modelAndView;
            }
        }else if(identityid==2){
            Student student=userService.selectStudentByid(username);
//            System.out.println(student.toString());
            if(student==null||(student.getPassword().equals(password))==false){
                modelAndView.setViewName("/view/login");
                modelAndView.addObject("msg", StaticFinalVar.USERNAME_OR_PWD_ERR);
                return modelAndView;
            }else{
                User user=new User(username,password,identityid);
                session.setAttribute("user",user);
                session.setAttribute("student",student);
                List<LimitVo> limitVoList=userService.limitgrouplogin(identityid);
                session.setAttribute("limitList",limitVoList);
                modelAndView.setViewName("/view/index");
                return modelAndView;
            }
        }else{
            Teacher teacher=userService.selectTeacherById(username);
            int identityidByTid=userService.findIdentityidByTid(username);
            if(teacher==null||(teacher.getPassword().equals(password))==false||identityid!=identityidByTid){
                modelAndView.setViewName("/view/login");
                modelAndView.addObject("msg", StaticFinalVar.USERNAME_OR_PWD_ERR);
                return modelAndView;
            }else{
                User user=new User(username,password,identityid);
                session.setAttribute("user",user);
                session.setAttribute("teacher",teacher);
                List<LimitVo> limitVoList=userService.limitgrouplogin(identityid);
                session.setAttribute("limitList",limitVoList);
                modelAndView.setViewName("/view/index");
                return modelAndView;
            }
        }
    }
}
