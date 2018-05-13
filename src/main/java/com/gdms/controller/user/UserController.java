package com.gdms.controller.user;

import cc.openkit.common.KitUtil;
import com.alibaba.fastjson.JSONObject;
import com.gdms.model.Department;
import com.gdms.model.Major;
import com.gdms.model.Student;
import com.gdms.model.Teacher;
import com.gdms.service.user.*;
import com.gdms.util.StaticFinalVar;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @Resource
    private UserService userService;

    @Resource
    private StudentService studentService;

    @Resource
    private TeacherService teacherService;

    @Resource
    private DepartmentService departmentService;

    @Resource
    private MajorService majorService;

    @RequestMapping(value = "/goStudent", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView studentinfo(HttpSession session){
        ModelAndView mv = new ModelAndView();
        List<Department> departmentList= departmentService.queryAllList();
        List<Major> majorList= majorService.queryAllList();
        mv.addObject("departmentList",departmentList);
        mv.addObject("majorList",majorList);
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
        String did =request.getParameter("department");
        String mid= request.getParameter("major");
        Student student=new Student();
        List<Student> studentList = null;
        if(search.equals("")&&did.equals("")&&mid.equals("")){
            search=null;
            did=null;
            mid=null;
            //封装数据
            student.setSid(search);
            // 分页查询
            studentList = studentService.queryPageListByWhere(student, Integer.valueOf(page), Integer.valueOf(limit));
        }else if(search.equals("")&&(!did.equals(""))&&mid.equals("")){
            search=null;
            mid=null;
            student.setSid(search);
            student.setDid(Integer.valueOf(did));
            student.setMid(Integer.valueOf(mid));
            studentList = studentService.getStudentList(student, Integer.valueOf(page), Integer.valueOf(limit));
        }else if(search.equals("")&&did.equals("")&&(!mid.equals(""))){
            search=null;
            did=null;
            student.setSid(search);
            student.setDid(Integer.valueOf(did));
            student.setMid(Integer.valueOf(mid));
            studentList = studentService.getStudentList(student, Integer.valueOf(page), Integer.valueOf(limit));
        }else if(search.equals("")&&(!did.equals(""))&&(!mid.equals(""))){
            search=null;
            student.setSid(search);
            student.setDid(Integer.valueOf(did));
            student.setMid(Integer.valueOf(mid));
            studentList = studentService.getStudentList(student, Integer.valueOf(page), Integer.valueOf(limit));
        }else if((!search.equals(""))&&did.equals("")&&mid.equals("")){
            did=null;
            mid=null;
            //封装数据
            student.setSid(search);
            student.setDid(Integer.valueOf(did));
            student.setMid(Integer.valueOf(mid));
            // 分页查询
            studentList = studentService.getStudentList(student, Integer.valueOf(page), Integer.valueOf(limit));
        }else if((!search.equals(""))&&(!did.equals(""))&&mid.equals("")){
            mid=null;
            //封装数据
            student.setSid(search);
            student.setDid(Integer.valueOf(did));
            student.setMid(Integer.valueOf(mid));
            // 分页查询
            studentList = studentService.getStudentList(student, Integer.valueOf(page), Integer.valueOf(limit));
        }else if((!search.equals(""))&&did.equals("")&&(!mid.equals(""))){
            did=null;
            //封装数据
            student.setSid(search);
            student.setDid(Integer.valueOf(did));
            student.setMid(Integer.valueOf(mid));
            // 分页查询
            studentList = studentService.getStudentList(student, Integer.valueOf(page), Integer.valueOf(limit));
        }else if((!search.equals(""))&&(!did.equals(""))&&(!mid.equals(""))){
            //封装数据
            student.setSid(search);
            student.setDid(Integer.valueOf(did));
            student.setMid(Integer.valueOf(mid));
            // 分页查询
            studentList = studentService.getStudentList(student, Integer.valueOf(page), Integer.valueOf(limit));
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

    @RequestMapping(value = "/goAddStudent", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goAddStudent(HttpSession session){
        ModelAndView mv = new ModelAndView();
        List<Department> departmentList= departmentService.queryAllList();
        List<Major> majorList= majorService.queryAllList();
        mv.addObject("departmentList",departmentList);
        mv.addObject("majorList",majorList);
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
        int sex =Integer.valueOf(request.getParameter("sex"));
        int did =Integer.valueOf(request.getParameter("did"));
        int mid =Integer.valueOf(request.getParameter("mid"));
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
        Student student1=studentService.queryStudentBySid(sid);
        // 如果没有重复，先添加，然后查询这条数据
        if(student1==null) {
            Major major=majorService.queryMajorByMid(mid);
            if (did==major.getDid()) {
                int i = studentService.insertStudent(student);
                if (i > 0) {
                    map = KitUtil.returnMap("200", StaticFinalVar.ADD_OK);
                    return JSONObject.toJSON(map);
                } else {
                    map = KitUtil.returnMap("101", StaticFinalVar.ADD_ERR);
                    return JSONObject.toJSON(map);
                }
            }else{
                map = KitUtil.returnMap("101", StaticFinalVar.MAJOR_ERR);
                return JSONObject.toJSON(map);
            }
        }else{
            map = KitUtil.returnMap("101", StaticFinalVar.USERHAVE_ERR);
            return JSONObject.toJSON(map);
        }
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

    @RequestMapping(value = "/deleteAllStudent", method = RequestMethod.POST)
    @ResponseBody
    public Object delAllStudent(@RequestBody Student[] students, HttpServletRequest request){
        Map<String, Object> map1 = new HashMap<String, Object>();
        int j;
        for(Student list:students){
           j=studentService.deleteById(list.getId());
           if(j>0){
           }else{
               map1=KitUtil.returnMap("200",StaticFinalVar.DEL_ERR);
           }
        }
        if(map1.size()>0){
        }else{
            map1=KitUtil.returnMap("101",StaticFinalVar.DEL_OK);
        }
        return JSONObject.toJSON(map1);
    }


    @RequestMapping(value = "/goTeacher", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView teacherinfo(HttpSession session){
        ModelAndView mv = new ModelAndView();
        List<Department> departmentList= departmentService.queryAllList();
        List<Major> majorList= majorService.queryAllList();
        mv.addObject("departmentList",departmentList);
        mv.addObject("majorList",majorList);
        mv.setViewName("/view/user/teacher");
        return mv;
    }

    @RequestMapping(value = "/teacherGetAllJson")
    @ResponseBody
    public Object TeacherGetAllJson(HttpServletRequest request){
        log.info("返回关于老师信息的json");
        Map<String,Object> map = new HashMap<String,Object>();
        String page = request.getParameter("page");// 获得页数
        String limit = request.getParameter("limit");// 获得每页显示条数
        String search = request.getParameter("search");// 获取搜索条件
        String did =request.getParameter("did");
        String mid= request.getParameter("mid");
        Teacher teacher =new Teacher();
        List<Teacher> teacherList =null;
        if(search.equals("")&&did.equals("")&&mid.equals("")){
            search=null;
            did=null;
            mid=null;
            //封装数据
            teacher.setTid(search);
            // 分页查询
            teacherList = teacherService.queryPageListByWhere(teacher, Integer.valueOf(page), Integer.valueOf(limit));
        }else if(search.equals("")&&(!did.equals(""))&&mid.equals("")){
            search=null;
            mid=null;
            teacher.setTid(search);
            teacher.setDid(Integer.valueOf(did));
            teacher.setMid(Integer.valueOf(mid));
            teacherList = teacherService.getTeacherList(teacher, Integer.valueOf(page), Integer.valueOf(limit));
        }else if(search.equals("")&&did.equals("")&&(!mid.equals(""))){
            search=null;
            did=null;
            teacher.setTid(search);
            teacher.setDid(Integer.valueOf(did));
            teacher.setMid(Integer.valueOf(mid));
            teacherList = teacherService.getTeacherList(teacher, Integer.valueOf(page), Integer.valueOf(limit));
        }else if(search.equals("")&&(!did.equals(""))&&(!mid.equals(""))){
            search=null;
            teacher.setTid(search);
            teacher.setDid(Integer.valueOf(did));
            teacher.setMid(Integer.valueOf(mid));
            teacherList = teacherService.getTeacherList(teacher, Integer.valueOf(page), Integer.valueOf(limit));
        }else if((!search.equals(""))&&did.equals("")&&mid.equals("")){
            did=null;
            mid=null;
            //封装数据
            teacher.setTid(search);
            teacher.setDid(Integer.valueOf(did));
            teacher.setMid(Integer.valueOf(mid));
            teacherList = teacherService.getTeacherList(teacher, Integer.valueOf(page), Integer.valueOf(limit));
        }else if((!search.equals(""))&&(!did.equals(""))&&mid.equals("")){
            mid=null;
            //封装数据
            teacher.setTid(search);
            teacher.setDid(Integer.valueOf(did));
            teacher.setMid(Integer.valueOf(mid));
            teacherList = teacherService.getTeacherList(teacher, Integer.valueOf(page), Integer.valueOf(limit));
        }else if((!search.equals(""))&&did.equals("")&&(!mid.equals(""))){
            did=null;
            //封装数据
            teacher.setTid(search);
            teacher.setDid(Integer.valueOf(did));
            teacher.setMid(Integer.valueOf(mid));
            teacherList = teacherService.getTeacherList(teacher, Integer.valueOf(page), Integer.valueOf(limit));
        }else if((!search.equals(""))&&(!did.equals(""))&&(!mid.equals(""))){
            //封装数据
            teacher.setTid(search);
            teacher.setDid(Integer.valueOf(did));
            teacher.setMid(Integer.valueOf(mid));
            teacherList = teacherService.getTeacherList(teacher, Integer.valueOf(page), Integer.valueOf(limit));
        }
        // 分页查询
        int size = teacherService.queryCount(teacher);
        // 返回数据
        map.put("code",0);
        map.put("msg","");
        map.put("count",size);
        map.put("data",teacherList);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/goAddTeacher", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goAddTeacher(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/user/addteacher");
        return mv;
    }

    /**
     * 添加老师
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
    @ResponseBody
    public Object addteacher(HttpServletRequest request){

        Map<String, Object> map = new HashMap<String, Object>();

        log.info("老师 》 添加 》 保存");
        // 获取分组名字
        String tid = request.getParameter("tid");
        String tname = request.getParameter("tname");
        Integer sex =Integer.valueOf(request.getParameter("sex"));
        Integer did =Integer.valueOf(request.getParameter("did"));
        Integer mid =Integer.valueOf(request.getParameter("mid"));
        String workTime = request.getParameter("workTime");
        String hdegree= request.getParameter("hdegree");
        String teachingDirection= request.getParameter("teachingDirection");
        String position=request.getParameter("position");
        Integer identityId=Integer.valueOf(request.getParameter("identityId"));
        // 先保存组
       Teacher teacher=new Teacher();
       teacher.setTid(tid);
       teacher.setTname(tname);
       teacher.setSex(sex);
       teacher.setDid(did);
       teacher.setMid(mid);
       teacher.setWorkTime(workTime);
       teacher.setHdegree(hdegree);
       teacher.setTeachingDirection(teachingDirection);
       teacher.setPosition(position);
       teacher.setIdentityId(identityId);
        // 查询是否有重复的分组
        List<Teacher> teacherList=teacherService.queryListByWhere(teacher);
        // 如果有重复
        if(teacherList.size()>0){
            map = KitUtil.returnMap("101",StaticFinalVar.IS_NOT_NULL);
            return JSONObject.toJSON(map);
        }
        // 如果没有重复，先添加，然后查询这条数据
        int i = teacherService.insertTeacher(teacher);
        if(i!=1){
            map = KitUtil.returnMap("101",StaticFinalVar.ADD_ERR);
            return JSONObject.toJSON(map);
        }
        map = KitUtil.returnMap("200",StaticFinalVar.ADD_OK);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/goUpdateTeacher", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView updateTeacher(HttpSession session,HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        Integer id = Integer.valueOf(request.getParameter("id"));
        Teacher teacher=teacherService.queryById(id);
        mv.addObject("teacher",teacher);
        mv.setViewName("/view/user/updateTeacher");
        return mv;
    }


    /**
     * 修改 老师信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateTeacher", method = RequestMethod.POST)
    @ResponseBody
    public Object updateT(HttpServletRequest request){
        log.info("用户 》 修改 》 保存");
        Integer id = Integer.valueOf(request.getParameter("id"));
        String tid = request.getParameter("tid");
        String tname = request.getParameter("tname");
        Integer sex = Integer.valueOf(request.getParameter("sex"));
        Integer did = Integer.valueOf(request.getParameter("did"));
        Integer mid = Integer.valueOf(request.getParameter("mid"));
        String workTime = request.getParameter("workTime");
        String hdegree= request.getParameter("hdegree");
        String teachingDirection= request.getParameter("teachingDirection");
        String position=request.getParameter("position");
        Integer identityId=Integer.valueOf(request.getParameter("identityId"));
        Teacher teacher=new Teacher();
        teacher.setId(id);
        teacher.setTid(tid);
        teacher.setTname(tname);
        teacher.setSex(sex);
        teacher.setDid(did);
        teacher.setMid(mid);
        teacher.setWorkTime(workTime);
        teacher.setHdegree(hdegree);
        teacher.setTeachingDirection(teachingDirection);
        teacher.setPosition(position);
        teacher.setIdentityId(identityId);
        int i=teacherService.updateTeacher(teacher);
        return JSONObject.toJSON(i==1 ? KitUtil.returnMap("200",StaticFinalVar.UPDATE_OK) : KitUtil.returnMap("101",StaticFinalVar.UPDATE_ERR));
    }

    @RequestMapping(value = "/delTeacher", method = RequestMethod.POST)
    @ResponseBody
    public Object delT(HttpServletRequest request){
        Map<String, Object> map = new HashMap<String, Object>();
        Integer id = Integer.valueOf(request.getParameter("id"));
        // 删除
        int i = teacherService.deleteById(id);
        map = (i>0)? KitUtil.returnMap("200", StaticFinalVar.DEL_OK):KitUtil.returnMap("101",StaticFinalVar.DEL_ERR);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/deleteAllTeacher", method = RequestMethod.POST)
    @ResponseBody
    public Object delAllTeacher(@RequestBody Teacher[] teachers, HttpServletRequest request){
        Map<String, Object> map1 = new HashMap<String, Object>();
        int j;
        for(Teacher list:teachers){
            j=teacherService.deleteById(list.getId());
            if(j>0){
            }else{
                map1=KitUtil.returnMap("200",StaticFinalVar.DEL_ERR);
            }
        }
        if(map1.size()>0){
        }else{
            map1=KitUtil.returnMap("101",StaticFinalVar.DEL_OK);
        }
        return JSONObject.toJSON(map1);
    }

    @RequestMapping(value = "/goTeacherIdentity", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView teacherIdentityInfo(HttpSession session){
        ModelAndView mv = new ModelAndView();
        List<Department> departmentList= departmentService.queryAllList();
        List<Major> majorList= majorService.queryAllList();
        mv.addObject("departmentList",departmentList);
        mv.addObject("majorList",majorList);
        mv.setViewName("/view/user/teacherIdentity");
        return mv;
    }


}
