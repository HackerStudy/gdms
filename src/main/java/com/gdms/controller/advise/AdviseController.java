package com.gdms.controller.advise;


import cc.openkit.common.KitUtil;
import com.alibaba.fastjson.JSONObject;
import com.gdms.controller.user.AdminController;
import com.gdms.model.*;
import com.gdms.service.TeacherContact.TeacherContactService;
import com.gdms.service.advise.AdviseService;
import com.gdms.service.advise.AdviseTAndSService;
import com.gdms.service.advise.AdviseTeacherService;
import com.gdms.service.user.StudentService;
import com.gdms.service.user.TeacherService;
import com.gdms.util.StaticFinalVar;
import com.gdms.vo.AdviseStudentVo;
import com.gdms.vo.AdviseTeacherVo;
import com.gdms.vo.AdviseVo;
import com.gdms.vo.StudentVo;
import org.apache.log4j.Logger;
import org.json.HTTP;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.print.attribute.standard.Sides;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/advise")
public class AdviseController {
    private Logger log = Logger.getLogger(AdminController.class);

    @Resource
    private AdviseService adviseService;

    @Resource
    private TeacherService teacherService;

    @Resource
    private TeacherContactService teacherContactService;

    @Resource
    private AdviseTeacherService adviseTeacherService;

    @Resource
    private AdviseTAndSService adviseTAndSService;

    @Resource
    private StudentService studentService;

    @RequestMapping(value = "/goAdvise", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goAdvise(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/adviser/choiceAdvise");
        return mv;
    }


    @RequestMapping(value = "/adviseGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object adviseGetAllJson(HttpServletRequest request,HttpSession session){
        log.info("查看所有的分组，返回 json");
        Map<String,Object> map = new HashMap<String,Object>();
        int page = Integer.valueOf(request.getParameter("page"));// 获得页数
        int limit = Integer.valueOf(request.getParameter("limit"));// 获得每页显示条数
        Student student=(Student) session.getAttribute("student");
        Integer did=student.getDid();
        Integer identity=3;
        Teacher teacher=new Teacher();
        List<AdviseTeacherVo> adviseTeacherVoList =teacherService.queryPageAdviseTeacherVoListByDid(did,identity,page,limit);
        int size = teacherService.queryCountAdviseTeacherVoByDid(did,identity);
        // 返回数据
        map.put("code",0);
        map.put("msg","");
        map.put("count",size);
        map.put("data",adviseTeacherVoList);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    @ResponseBody
    public Object addApply(HttpServletRequest request,HttpSession session){
        Map<String, Object> map = new HashMap<String, Object>();
        log.info("分组 》 添加 》 保存");
        // 获取分组名字
        User user =(User) session.getAttribute("user");
        String sid=user.getUsername();
        String tid = request.getParameter("tid");
        int haveNumber=Integer.valueOf(request.getParameter("haveNumber"));
        int limitNumber=Integer.valueOf(request.getParameter("limitNumber"));
        // 先保存组
        Advise advise1=adviseService.queryAdviseBySid(sid);
        Advise advise=new Advise();
        advise.setSid(sid);
        advise.setTid(tid);
        if(advise1!=null){
            if(advise1.getPass()!=2){
                map = KitUtil.returnMap("101", StaticFinalVar.APPLYTTEACHER_OK_);
                return JSONObject.toJSON(map);
            }else{
                if(limitNumber-haveNumber>=0) {
                    advise.setId(advise1.getId());
                    advise.setPass(0);
                    int j = adviseService.updateAdvise(advise);
                    if (j > 0) {
                        map = KitUtil.returnMap("200", StaticFinalVar.APPLY_OK_);
                        return JSONObject.toJSON(map);
                    } else {
                        map = KitUtil.returnMap("101", StaticFinalVar.APPLY_ERR_);
                        return JSONObject.toJSON(map);
                    }
                }else{
                    map = KitUtil.returnMap("101", StaticFinalVar.APPLYTNUMBER_ERR);
                    return JSONObject.toJSON(map);
                }
            }
        }else{
            if(limitNumber-haveNumber>=0) {
                int j = adviseService.insertAdvise(advise);
                if (j > 0) {
                    map = KitUtil.returnMap("200", StaticFinalVar.APPLY_OK_);
                    return JSONObject.toJSON(map);
                } else {
                    map = KitUtil.returnMap("101", StaticFinalVar.APPLY_ERR_);
                    return JSONObject.toJSON(map);
                }
            }else{
                map = KitUtil.returnMap("101", StaticFinalVar.APPLYTNUMBER_ERR);
                return JSONObject.toJSON(map);
            }
        }
    }

    @RequestMapping(value = "/golookChoiceResult", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView golookChoiceResult(HttpSession session){
        ModelAndView mv = new ModelAndView();
        Student student=(Student) session.getAttribute("student");
        Advise advise=adviseService.queryAdviseBySid(student.getSid());
        if(advise!=null){
            String tid=advise.getTid();
            Teacher teacher=teacherService.queryTeacherByTid(advise.getTid());
            List<TeacherContact> teacherContactList=teacherContactService.queryTeacherContactList();
            TeacherContact teacherContact=null;
            for(TeacherContact list:teacherContactList){
                if(list.getTid().equals(teacher.getTid())){
                    teacherContact=new TeacherContact(list.getId(),list.getTid(),list.getEmail(),list.getPhone());
                }
            }
            mv.addObject("teacher1",teacher);
            mv.addObject("advise",advise);
            mv.addObject("teacherContact",teacherContact);
            mv.addObject("code","200");
            mv.setViewName("/view/adviser/lookChoiceResult");
        }else{
            mv.addObject("code","101");
            mv.setViewName("/view/adviser/lookChoiceResult");
        }
        return mv;
    }

    @RequestMapping(value = "/retreat", method = RequestMethod.POST)
    @ResponseBody
    public Object retreat(HttpServletRequest request,HttpSession session){
        Map<String, Object> map = new HashMap<String, Object>();
        Student student =(Student) session.getAttribute("student");
        String id=request.getParameter("id");
        String tid=request.getParameter("tid");
        String sid=student.getSid();
        int i=adviseService.deleteByTidAndSid(tid,student.getSid());
        // 先保存组
        return i==1?KitUtil.returnMap("200",StaticFinalVar.RETREAT_OK):KitUtil.returnMap("101",StaticFinalVar.RETREAT_EOR);
    }

    @RequestMapping(value = "/golookApplyStudent", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView golookApplyStuent(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/adviser/lookApplyStudent");
        return mv;
    }


    @RequestMapping(value = "/applyStudentGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object applyStudentGetAllJson(HttpServletRequest request,HttpSession session){
        log.info("查看所有的分组，返回 json");
        Map<String,Object> map = new HashMap<String,Object>();
        String page = request.getParameter("page");// 获得页数
        String limit = request.getParameter("limit");// 获得每页显示条数
        Teacher teacher=(Teacher) session.getAttribute("teacher");
//        Student student=new Student();
        List<Advise> adviseList=adviseService.queryPageByTid(teacher.getTid(),0,Integer.valueOf(page),Integer.valueOf(limit));
        List<Student> studentList= studentService.queryAll();
        List<StudentVo> studentVoList=new ArrayList<StudentVo>();
        for (Student list:studentList) {
            for(Advise list2:adviseList){
                if(list2.getSid().equals(list.getSid())){
                    StudentVo studentVo=new StudentVo(list.getId(),list.getSid(),list.getName(),list.getSex(),list.getDid(),list.getMid(),list.getGrade(),list.getSclass(),list.getPhone(),list.getEmail());
                    studentVoList.add(studentVo);
                }
            }
        }
        int size = adviseService.queryCount(teacher.getTid());
        // 返回数据
        map.put("code",0);
        map.put("msg","");
        map.put("count",size);
        map.put("data",studentVoList);
        return JSONObject.toJSON(map);
    }


    @RequestMapping(value = "/correctApply", method = RequestMethod.POST)
    @ResponseBody
    public Object correctApply(HttpServletRequest request,HttpSession session){
        Map<String, Object> map = new HashMap<String, Object>();
        Teacher teacher=(Teacher) session.getAttribute("teacher");
        String sid=request.getParameter("sid");
        AdviseTeacher adviseTeacher2=adviseTeacherService.queryAdviseTeacherByTid(teacher.getTid());
        Integer code=Integer.valueOf(request.getParameter("code"));
        if (code == 200) {
            if(adviseTeacher2.getLimitNumber()-adviseTeacher2.getHaveNumber()>0) {
                Advise advise = adviseService.queryAdviseBySid(sid);
                Advise advise1 = new Advise();
                advise1.setId(advise.getId());
                advise1.setPass(1);
                AdviseTeacher adviseTeacher1 = adviseTeacherService.queryAdviseTeacherByTid(teacher.getTid());
                AdviseTeacher adviseTeacher = new AdviseTeacher();
                adviseTeacher.setId(adviseTeacher1.getId());
                adviseTeacher.setHaveNumber(adviseTeacher1.getHaveNumber() + 1);
                AdviseTAndS adviseTAndS = new AdviseTAndS();
                adviseTAndS.setSid(sid);
                adviseTAndS.setTid(teacher.getTid());
                Student student1 = studentService.queryStudentBySid(sid);
                int j = adviseService.updateAdvise(advise1);
                int i = adviseTeacherService.updateAdviseTeacher(adviseTeacher);
                int c = adviseTAndSService.insertAdviseTAndS(adviseTAndS);
                int f = studentService.updateNewStudent(teacher.getId(), student1.getId());
                if (j > 0 && i > 0 && c > 0 && f > 0) {
                    map.put("code", "200");
                    map.put("msg", StaticFinalVar.OOPTION_OK);
                } else {
                    map.put("code", "101");
                    map.put("msg", StaticFinalVar.OOPTION_ERR);
                }
            }else{
                map.put("code", "101");
                map.put("msg", StaticFinalVar.APPROVAL_ERR);
            }
        } else {
            Advise advise = adviseService.queryAdviseBySid(sid);
            Advise advise1 = new Advise();
            advise1.setId(advise.getId());
            advise1.setPass(2);
            int j = adviseService.updateAdvise(advise1);
            if (j > 0) {
                map.put("code", "200");
                map.put("msg", StaticFinalVar.OOPTION_OK);
            } else {
                map.put("code", "101");
                map.put("msg", StaticFinalVar.OOPTION_ERR);
            }
        }
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/golookCrayyStudent", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView golookCrayyStuent(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/adviser/lookCarryStudent");
        return mv;
    }

    @RequestMapping(value = "/CarryStudentGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object CarryStudentGetAllJson(HttpServletRequest request,HttpSession session){
        log.info("查看所有的分组，返回 json");
        Map<String,Object> map = new HashMap<String,Object>();
        String page = request.getParameter("page");// 获得页数
        String limit = request.getParameter("limit");// 获得每页显示条数
        Teacher teacher=(Teacher) session.getAttribute("teacher");
        List<AdviseStudentVo> adviseStudentVoList=studentService.queryPageAdviseStudent(teacher.getTid(),Integer.valueOf(page),Integer.valueOf(limit));
        // 分页查询
        int size = studentService.queryCountAdviseStudent(teacher.getTid());
        // 返回数据
        map.put("code",0);
        map.put("msg","");
        map.put("count",size);
        map.put("data",adviseStudentVoList);
        return JSONObject.toJSON(map);
    }



    @RequestMapping(value = "/golookAdvise", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView golookAdvise(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/adviser/lookAdvise");
        return mv;
    }

    @RequestMapping(value = "/AllAdviseTeacherGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object AllAdviseTeacherGetAllJson(HttpServletRequest request,HttpSession session){
        log.info("查看所有的分组，返回 json");
        Map<String,Object> map = new HashMap<String,Object>();
        int page = Integer.valueOf(request.getParameter("page"));// 获得页数
        int limit = Integer.valueOf(request.getParameter("limit"));// 获得每页显示条数
        List<AdviseTeacherVo> adviseTeacherVoList=teacherService.queryPageAdviseTeacherVoList(page,limit);
        // 分页查询
        int size = teacherService.queryCountAdviseTeacherVo();
        // 返回数据
        map.put("code",0);
        map.put("msg","");
        map.put("count",size);
        map.put("data",adviseTeacherVoList);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/golookDistributionAdvise", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView golookDistributionAdvise(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/adviser/distributionAdvise");
        return mv;
    }

    @RequestMapping(value = "/distributionAdviseGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object distributionAdviseGetAllJson(HttpServletRequest request,HttpSession session){
        Map<String,Object> map = new HashMap<String,Object>();
        int page = Integer.valueOf(request.getParameter("page"));// 获得页数
        int limit = Integer.valueOf(request.getParameter("limit"));// 获得每页显示条数
        List<AdviseTeacherVo> adviseTeacherVoList=teacherService.queryPageAdviseTeacherVoList(page,limit);
        // 分页查询
        int size = teacherService.queryCountAdviseTeacherVo();
        // 返回数据
        map.put("code",0);
        map.put("msg","");
        map.put("count",size);
        map.put("data",adviseTeacherVoList);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/goDistribution", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goDistribution(HttpServletRequest request,HttpSession session){
        ModelAndView mv = new ModelAndView();
        int id=Integer.valueOf(request.getParameter("id"));
        String tid=request.getParameter("tid");
        Teacher teacher=new Teacher();
        teacher.setId(id);
        teacher.setTid(tid);
        mv.setViewName("/view/adviser/distribution");
        session.setAttribute("adviserTeacher",teacher);
        return mv;
    }

    @RequestMapping(value = "/distributionGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object distributionGetAllJson(HttpServletRequest request,HttpSession session){
        Map<String,Object> map = new HashMap<String,Object>();
        int page = Integer.valueOf(request.getParameter("page"));// 获得页数
        int limit = Integer.valueOf(request.getParameter("limit"));// 获得每页显示条数
        List<AdviseStudentVo> adviseStudentVoList=studentService.queryPageDistributionStudent(page,limit);
        // 分页查询
        int size = studentService.queryCountDistributionStudent();
        // 返回数据
        map.put("code",0);
        map.put("msg","");
        map.put("count",size);
        map.put("data",adviseStudentVoList);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/allot", method = RequestMethod.POST)
    @ResponseBody
    public Object allot(HttpServletRequest request,HttpSession session){
        Map<String, Object> map = new HashMap<String, Object>();
        int id=Integer.valueOf(request.getParameter("id"));
        String sid=request.getParameter("sid");
        Teacher teacher=(Teacher) session.getAttribute("adviserTeacher");
        AdviseTeacher adviseTeacher1=adviseTeacherService.queryAdviseTeacherByTid(teacher.getTid());
        AdviseTeacher adviseTeacher=new AdviseTeacher();
        adviseTeacher.setTid(teacher.getTid());
        adviseTeacher.setHaveNumber(adviseTeacher1.getHaveNumber()+1);
        int i=adviseTeacherService.updateAdviseTeacherByTid(adviseTeacher);
        AdviseTAndS adviseTAndS=new AdviseTAndS();
        adviseTAndS.setSid(sid);
        adviseTAndS.setTid(teacher.getTid());
        int j=adviseTAndSService.insertAdviseTAndS(adviseTAndS);
        Student student=new Student();
        student.setId(id);
        student.setAdviserid(teacher.getId());
        int q=studentService.updateStudent(student);
        // 先保存组
        return KitUtil.returnMap("200",StaticFinalVar.ALLOT_OK);
    }

    @RequestMapping(value = "/allAllot", method = RequestMethod.POST)
    @ResponseBody
    public Object allAllot(@RequestBody AdviseStudentVo[] adviseStudentVos,HttpServletRequest request, HttpSession session){
        Map<String, Object> map = new HashMap<String, Object>();
        Teacher teacher=(Teacher) session.getAttribute("adviserTeacher");
        int length=adviseStudentVos.length;
        AdviseTeacher adviseTeacher1=adviseTeacherService.queryAdviseTeacherByTid(teacher.getTid());
        int remain = adviseTeacher1.getLimitNumber()-adviseTeacher1.getHaveNumber();
        if(remain>=length){
            AdviseTeacher adviseTeacher=new AdviseTeacher();
            adviseTeacher.setTid(teacher.getTid());
            adviseTeacher.setHaveNumber(adviseTeacher1.getHaveNumber()+length);
            int i=adviseTeacherService.updateAdviseTeacherByTid(adviseTeacher);
            for(AdviseStudentVo list:adviseStudentVos){
                AdviseTAndS adviseTAndS=new AdviseTAndS();
                adviseTAndS.setSid(list.getSid());
                adviseTAndS.setTid(teacher.getTid());
                int j=adviseTAndSService.insertAdviseTAndS(adviseTAndS);
                Student student=new Student();
                student.setId(list.getId());
                student.setAdviserid(teacher.getId());
                int q=studentService.updateStudent(student);
            }
            // 先保存组
            return KitUtil.returnMap("200",StaticFinalVar.ALLOT_OK);
        }else{
            // 先保存组
            return KitUtil.returnMap("101",StaticFinalVar.ALLOT_ERR);
        }
    }

    @RequestMapping(value = "/goSetLimitNumber", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goSetLimitNumber(HttpSession session){
        ModelAndView mv = new ModelAndView();
        Teacher teacher=(Teacher) session.getAttribute("teacher");
        AdviseTeacher adviseTeacher=adviseTeacherService.queryAdviseTeacherByTid(teacher.getTid());
        mv.addObject("adviseTeacher",adviseTeacher);
        mv.setViewName("/view/adviser/setLimitNumber");
        return mv;
    }

    @RequestMapping(value = "/updateLimitNumber", method = RequestMethod.POST)
    @ResponseBody
    public Object updateLimitNumber(HttpServletRequest request,HttpSession session){
        Map<String, Object> map = new HashMap<String, Object>();
        String tid=request.getParameter("tid");
        int limitNumber=Integer.valueOf(request.getParameter("limitNumber"));
        int haveNumber=Integer.valueOf(request.getParameter("haveNumber"));
        AdviseTeacher adviseTeacher=new AdviseTeacher();
        adviseTeacher.setTid(tid);
        adviseTeacher.setLimitNumber(limitNumber);
        if(haveNumber<=limitNumber){
            int i= adviseTeacherService.updateAdviseTeacherByTid(adviseTeacher);
            if (i > 0) {
                map.put("code", "200");
                map.put("msg", StaticFinalVar.UPDATE_OK);
            } else {
                map.put("code", "101");
                map.put("msg", StaticFinalVar.UPDATE_ERR);
            }
        }else{
            map.put("code", "101");
            map.put("msg", StaticFinalVar.LimitNumber_ERR);
        }
        return JSONObject.toJSON(map);
    }


}
