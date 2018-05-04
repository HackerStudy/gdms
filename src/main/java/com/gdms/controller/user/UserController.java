package com.gdms.controller.user;

import cc.openkit.common.KitUtil;
import com.alibaba.fastjson.JSONObject;
import com.gdms.model.Admin;
import com.gdms.model.GGroup;
import com.gdms.model.Student;
import com.gdms.service.user.StudentService;
import com.gdms.service.user.UserService;
import com.gdms.util.StaticFinalVar;
import io.netty.channel.ServerChannel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.naming.Name;
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

    @Resource
    private UserService userService;

    @Resource
    private StudentService studentService;

    @RequestMapping(value = "/goStudent", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView studentinfo(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/user/student");
        return mv;
    }

    @RequestMapping(value = "/studentGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object StudentGetAllJson(HttpServletRequest request){
        log.info("查看所有的分组，返回 json");
        Map<String,Object> map = new HashMap<String,Object>();
        String page = request.getParameter("page");// 获得页数
        String limit = request.getParameter("limit");// 获得每页显示条数
        String search = request.getParameter("search");// 获取搜索条件
        Student student;
        List<Student> studentList;
        if(search.equals("")){
            search=null;
            //封装数据
            student = new Student();
            student.setSid(search);
            // 分页查询
            studentList = studentService.queryPageListByWhere(student, Integer.valueOf(page), Integer.valueOf(limit));
        }else{
            student = new Student();
            student.setSid(search);
            studentList = studentService.searchStudentListBySid(search, Integer.valueOf(page), Integer.valueOf(limit));
        }
        // 分页查询
        int size = studentService.queryCount(student);
        // 返回数据
        map.put("code",0);
        map.put("msg","");
        map.put("count",size);
        map.put("data",studentList);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/teacher", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView teacherinfo(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/user/teacher");
        return mv;
    }

    @RequestMapping(value = "/goAddStudent", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goAddStudent(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/user/addstudent");
        return mv;
    }

    /**
     * 添加学生
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    @ResponseBody
    public Object addStudent(HttpServletRequest request){

        Map<String, Object> map = new HashMap<String, Object>();

        log.info("分组 》 添加 》 保存");
        // 获取分组名字
        String sid = request.getParameter("sid");
        String name = request.getParameter("name");
        Integer sex =Integer.valueOf(request.getParameter("sex"));
        Integer did =Integer.valueOf(request.getParameter("did"));
        Integer mid =Integer.valueOf(request.getParameter("mid"));
        String grade = request.getParameter("grade");
        String sclass = request.getParameter("sclass");
        String phone = request.getParameter("phone");
        String email= request.getParameter("email");
        // 先保存组
        Student student=new Student();
        student.setSid(sid);
        student.setName(name);
        student.setSex(sex);
        student.setDid(did);
        student.setMid(mid);
        student.setGrade(grade);
        student.setSclass(sclass);
        student.setPhone(phone);
        student.setEmail(email);
        // 查询是否有重复的分组
        List<Student> studentList=studentService.queryListByWhere(student);
        // 如果有重复
        if(studentList.size()>0){
            map = KitUtil.returnMap("101",StaticFinalVar.IS_NOT_NULL);
            return JSONObject.toJSON(map);
        }
        // 如果没有重复，先添加，然后查询这条数据
        int i = studentService.insertStudent(student);
        if(i!=1){
            map = KitUtil.returnMap("101",StaticFinalVar.ADD_ERR);
            return JSONObject.toJSON(map);
        }
        map = KitUtil.returnMap("200",StaticFinalVar.ADD_OK);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/goUpdateStudent", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView updateStudent(HttpSession session,HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        Integer id = Integer.valueOf(request.getParameter("id"));
        Student student=studentService.queryById(id);
        mv.addObject("student",student);
        mv.setViewName("/view/user/updateStudent");
        return mv;
    }


    /**
     * 修改 学生信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
    @ResponseBody
    public Object update(HttpServletRequest request){
        log.info("用户 》 修改 》 保存");
        Integer id = Integer.valueOf(request.getParameter("id"));
        String sid = request.getParameter("sid");
        String name = request.getParameter("name");
        Integer sex = Integer.valueOf(request.getParameter("sex"));
        Integer did = Integer.valueOf(request.getParameter("did"));
        Integer mid = Integer.valueOf(request.getParameter("mid"));
        String grade = request.getParameter("grade");
        String sclass = request.getParameter("sclass");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        Student student=new Student();
        student.setId(id);
        student.setSid(sid);
        student.setName(name);
        student.setSex(sex);
        student.setDid(did);
        student.setMid(mid);
        student.setGrade(grade);
        student.setSclass(sclass);
        student.setPhone(phone);
        student.setEmail(email);
        int i=studentService.updateStudent(student);
        return JSONObject.toJSON(i==1 ? KitUtil.returnMap("200",StaticFinalVar.UPDATE_OK) : KitUtil.returnMap("101",StaticFinalVar.UPDATE_ERR));
    }

    @RequestMapping(value = "/delStudent", method = RequestMethod.POST)
    @ResponseBody
    public Object del(HttpServletRequest request){
        Map<String, Object> map = new HashMap<String, Object>();
        Integer id = Integer.valueOf(request.getParameter("id"));
        // 删除
        int i = studentService.deleteById(id);
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
