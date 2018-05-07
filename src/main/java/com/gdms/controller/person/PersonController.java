package com.gdms.controller.person;

import cc.openkit.common.KitUtil;
import com.alibaba.fastjson.JSONObject;
import com.gdms.controller.user.UserController;
import com.gdms.model.Admin;
import com.gdms.model.Student;
import com.gdms.model.Teacher;
import com.gdms.model.User;
import com.gdms.service.admin.AdminService;
import com.gdms.service.user.StudentService;
import com.gdms.service.user.TeacherService;
import com.gdms.service.user.UserService;
import com.gdms.util.StaticFinalVar;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.print.attribute.standard.Sides;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Scope("prototype")
@RequestMapping("/person")
public class PersonController {
    private Logger log = Logger.getLogger(UserController.class);

    @Resource
    UserService userService;
    @Resource
    AdminService adminService;

    @Resource
    StudentService studentService;
    @Resource
    TeacherService teacherService;

    @RequestMapping(value = "/goPensonalInfo", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goPensonalInfo(HttpSession session){
        ModelAndView mv = new ModelAndView();
        User user=(User) session.getAttribute("user");
        if(user.getIdentity()==1||user.getIdentity()==5){
            Admin admin=adminService.selectUserByUsername(user.getUsername());
            mv.addObject("admin",admin);
            mv.setViewName("/view/personal/personalInfo");
        }else if(user.getIdentity()==2){
            Student student= studentService.queryStudentBySid(user.getUsername());
            mv.addObject("student",student);
            mv.setViewName("/view/personal/pensonalStudentInfo");
        }else{
            Teacher teacher= teacherService.queryTeacherByTid(user.getUsername());
            mv.addObject("teacher",teacher);
            mv.setViewName("/view/personal/pensonalTeacherInfo");
        }
        return mv;
    }

    @RequestMapping(value = "/updateAdmin", method = RequestMethod.POST)
    @ResponseBody
    public Object add(HttpServletRequest request){
        log.info("用户 》 添加 》 保存");
        String kitAdminId=request.getParameter("kitAdminId");
        String kitAdminName = request.getParameter("kitAdminName");
        String imgurl = request.getParameter("imgurl");
        String kitAdminUsername = request.getParameter("kitAdminUsername");
        Admin admin = new Admin();
        admin.setKitAdminId(kitAdminId);
        admin.setKitAdminName(kitAdminName);
        admin.setKitAdminUsername(kitAdminUsername);
        admin.setKitAdminImgUrl(imgurl);
        int i=adminService.updateByAdminId(admin);
        if(i>0){
            return JSONObject.toJSON(KitUtil.returnMap("200", StaticFinalVar.ADD_OK));
        }else {
            return JSONObject.toJSON(KitUtil.returnMap("101",StaticFinalVar.ADD_ERR));
        }
    }

    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
    @ResponseBody
    public Object updateStudent(HttpServletRequest request){
        log.info("用户 》 添加 》 保存");
        int id=Integer.valueOf(request.getParameter("id"));
        String icon = request.getParameter("icon");
        Student student=new Student();
        student.setId(id);
        student.setIcon(icon);
        int i=studentService.updateStudent(student);
        if(i>0){
            return JSONObject.toJSON(KitUtil.returnMap("200", StaticFinalVar.ADD_OK));
        }else {
            return JSONObject.toJSON(KitUtil.returnMap("101",StaticFinalVar.ADD_ERR));
        }
    }

    @RequestMapping(value = "/updateTeacher", method = RequestMethod.POST)
    @ResponseBody
    public Object updateTeacher(HttpServletRequest request){
        log.info("用户 》 添加 》 保存");
        int id=Integer.valueOf(request.getParameter("id"));
        String icon = request.getParameter("icon");
        Teacher teacher=new Teacher();
        teacher.setId(id);
        teacher.setIcon(icon);
        int i=teacherService.updateTeacher(teacher);
        if(i>0){
            return JSONObject.toJSON(KitUtil.returnMap("200", StaticFinalVar.ADD_OK));
        }else {
            return JSONObject.toJSON(KitUtil.returnMap("101",StaticFinalVar.ADD_ERR));
        }
    }

    @RequestMapping(value = "/goModifyPassword", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goModifyPassword(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/personal/modify_password");
        return mv;
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public Object updatePassword(HttpServletRequest request,HttpSession session){
        log.info("用户 》 添加 》 保存");
        User user =(User) session.getAttribute("user");
        String username=user.getUsername();
        int identity=user.getIdentity();
        String password=request.getParameter("password");
        if(identity==1||identity==5){
            String kitAdminId=adminService.findAdminIdByAdminUsername(username);
            Admin admin=new Admin();
            admin.setKitAdminId(kitAdminId);
            admin.setKitAdminPassword(password);
            int i=adminService.updateAdmin(admin);
            if(i>0){
                return JSONObject.toJSON(KitUtil.returnMap("200", StaticFinalVar.SEEK_PWD_OK));
            }else {
                return JSONObject.toJSON(KitUtil.returnMap("101",StaticFinalVar.SEEK_PWD_ERR));
            }
        }else if(user.getIdentity()==2){
            int id=studentService.queryIdBySid(username);
            Student student=new Student();
            student.setId(id);
            student.setPassword(password);
            int i =studentService.updateStudent(student);
            if(i>0){
                return JSONObject.toJSON(KitUtil.returnMap("200", StaticFinalVar.SEEK_PWD_OK));
            }else {
                return JSONObject.toJSON(KitUtil.returnMap("101",StaticFinalVar.SEEK_PWD_ERR));
            }
        }else{
            int id=teacherService.queryidByTid(username);
            Teacher teacher=new Teacher();
            teacher.setId(id);
            teacher.setPassword(password);
            int i=teacherService.updateTeacher(teacher);
            if(i>0){
                return JSONObject.toJSON(KitUtil.returnMap("200", StaticFinalVar.SEEK_PWD_OK));
            }else {
                return JSONObject.toJSON(KitUtil.returnMap("101",StaticFinalVar.SEEK_PWD_ERR));
            }
        }
    }
}
