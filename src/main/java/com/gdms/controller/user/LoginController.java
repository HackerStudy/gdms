package com.gdms.controller.user;

import com.gdms.model.Admin;
import com.gdms.model.Student;
import com.gdms.model.Teacher;
import com.gdms.model.User;
import com.gdms.service.admin.AdminService;
import com.gdms.service.user.UserService;
import com.gdms.util.StaticFinalVar;
import com.gdms.vo.LimitVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Resource
    AdminService adminService;
    @Resource
    UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, HttpSession session){
        ModelAndView modelAndView=new ModelAndView();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        int identityid=Integer.valueOf(request.getParameter("identityid"));
//        System.out.println("现在开始登录");
        if(identityid==1){
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
