package com.gdms.controller.reply;


import cc.openkit.common.KitUtil;
import com.alibaba.fastjson.JSONObject;
import com.gdms.controller.score.ScoreController;
import com.gdms.model.*;
import com.gdms.service.reply.*;
import com.gdms.service.topic.TopicApplyService;
import com.gdms.util.StaticFinalVar;
import com.gdms.vo.*;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/reply")
public class ReplyController {
    private Logger log = Logger.getLogger(ReplyController.class);

    @Resource
    ReplyGroupService replyGroupService;

    @Resource
    ReplyGroupTeacherService replyGroupTeacherService;

    @Resource
    ReplyGroupStudentService replyGroupStudentService;

    @Resource
    ReplyReviewService replyReviewService;

    @Resource
    StudentReplyScoreService studentReplyScoreService;

    @RequestMapping(value = "/goLookStayReplyGroup", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goLookStayReplyGroup(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/reply/lookStayReplyGroup");
        return mv;
    }

    @RequestMapping(value = "/stayReplyGroupGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object stayReplyGroupGetAllJson(HttpServletRequest request, HttpSession session){
        Map<String,Object> map = new HashMap<String,Object>();
        int page = Integer.valueOf(request.getParameter("page"));// 获得页数
        int limit = Integer.valueOf(request.getParameter("limit"));// 获得每页显示条数
        Student student=(Student) session.getAttribute("student");
        ReplyGroupStudent replyGroupStudent=replyGroupStudentService.queryReplyGroupStudentBySid(student.getSid());
        List<ReplyGroupVo> replyGroupVoList=replyGroupService.queryPageReplyGroupVoByGid(replyGroupStudent.getGid(),page,limit);
        // 分页查询
        int size = replyGroupService.queryCountReplyGroupVoByGid(replyGroupStudent.getGid());
        // 返回数据
        map.put("code",0);
        map.put("msg","");
        map.put("count",size);
        map.put("data",replyGroupVoList);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/goReplyGroupTeacher", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goReplyGroupTeacher(HttpServletRequest request,HttpSession session){
        ModelAndView mv = new ModelAndView();
        int groupId=Integer.valueOf(request.getParameter("id"));
        session.setAttribute("groupId3",groupId);
        mv.setViewName("/view/reply/replyGroupTeacher");
        return mv;
    }

    @RequestMapping(value = "/ReplyGroupTeacherGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object ReplyGroupTeacherGetAllJson(HttpServletRequest request, HttpSession session){
        Map<String,Object> map = new HashMap<String,Object>();
        int page = Integer.valueOf(request.getParameter("page"));// 获得页数
        int limit = Integer.valueOf(request.getParameter("limit"));// 获得每页显示条数
        int gid=new Integer(session.getAttribute("groupId3").toString());
        List<ReplyTeacherVo> replyTeacherVoList=replyGroupTeacherService.queryPageReplyTeacherVo(gid,page,limit);
        // 分页查询
        int size = replyGroupTeacherService.queryCountReplyTeacherVoByGid(gid);
        // 返回数据
        map.put("code",0);
        map.put("msg","");
        map.put("count",size);
        map.put("data",replyTeacherVoList);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/goReplyGroupStudent", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goReplyGroupStudent(HttpServletRequest request,HttpSession session){
        ModelAndView mv = new ModelAndView();
        int groupId=Integer.valueOf(request.getParameter("id"));
        session.setAttribute("groupId3",groupId);
        mv.setViewName("/view/reply/replyGroupStudent");
        return mv;
    }

    @RequestMapping(value = "/ReplyGroupStudentGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object ReplyGroupStudentGetAllJson(HttpServletRequest request, HttpSession session){
        Map<String,Object> map = new HashMap<String,Object>();
        int page = Integer.valueOf(request.getParameter("page"));// 获得页数
        int limit = Integer.valueOf(request.getParameter("limit"));// 获得每页显示条数
        int gid=new Integer(session.getAttribute("groupId3").toString());
        List<ReplyStudentVo> replyStudentVoList=replyGroupStudentService.queryPageReplyStudentVo(gid,page,limit);
        // 分页查询
        int size = replyGroupStudentService.queryCountReplyStudentVoByGid(gid);
        // 返回数据
        map.put("code",0);
        map.put("msg","");
        map.put("count",size);
        map.put("data",replyStudentVoList);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/goLookOnselfStudentReplyScore", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goLookOnselfStudentReplyScore(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/reply/lookOnselfStudentReplyScore");
        return mv;
    }

    @RequestMapping(value = "/OnselfStudentScoreGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object OnselfStudentScoreGetAllJson(HttpServletRequest request, HttpSession session){
        Map<String,Object> map = new HashMap<String,Object>();
        int page = Integer.valueOf(request.getParameter("page"));// 获得页数
        int limit = Integer.valueOf(request.getParameter("limit"));// 获得每页显示条数
        Teacher teacher=(Teacher) session.getAttribute("teacher");
        List<StudentReplyScoreVo> studentReplyScoreVoList=studentReplyScoreService.queryPageStuentReplyScoreVoByTid(teacher.getTid(),page,limit);
        // 分页查询
        int size = studentReplyScoreService.queryCountStuentReplyScoreVoByTid(teacher.getTid());
        // 返回数据
        map.put("code",0);
        map.put("msg","");
        map.put("count",size);
        map.put("data",studentReplyScoreVoList);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/goLookPhaseReplyResult", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goLookPhaseReplyResult(HttpSession session){
        ModelAndView mv = new ModelAndView();
        Student student =(Student) session.getAttribute("student") ;
        StudentReplyScore studentReplyScore=studentReplyScoreService.queryStudentReplyScoreBySid(student.getSid());
        mv.addObject("studentReplyScore",studentReplyScore);
        mv.setViewName("/view/reply/lookPhaseReplyResult");
        return mv;
    }

    @RequestMapping(value = "/goSReplyGroupStudent", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goSReplyGroupStudent(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/reply/sreplyGroupStudent");
        return mv;
    }

    @RequestMapping(value = "/goSReplyGroupTeacher", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goSReplyGroupTeacher(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/reply/sreplyGroupTeacher");
        return mv;
    }

    @RequestMapping(value = "/goLookReplyGroupInfo", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goLookReplyGroupInfo(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/reply/lookReplyGroupInfo");
        return mv;
    }

    @RequestMapping(value = "/replyGroupGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object replyGroupGetAllJson(HttpServletRequest request, HttpSession session){
        Map<String,Object> map = new HashMap<String,Object>();
        Teacher teacher=(Teacher) session.getAttribute("teacher");
        ReplyGroupTeacher replyGroupTeacher=replyGroupTeacherService.queryReplyGroupTeacherByTid(teacher.getTid());
        ReplyGroup replyGroup=replyGroupService.queryById(replyGroupTeacher.getGid());
        List<ReplyGroup> replyGroupList=new ArrayList<ReplyGroup>();
        replyGroupList.add(replyGroup);
        map.put("code",0);
        map.put("msg","");
        map.put("data",replyGroupList);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/goDReplyGroupStudent", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goDReplyGroupStudent(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/reply/dreplyGroupStudent");
        return mv;
    }

    @RequestMapping(value = "/dReplyGroupStudentGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object dReplyGroupStudentGetAllJson(HttpServletRequest request, HttpSession session){
        Map<String,Object> map = new HashMap<String,Object>();
        int page = Integer.valueOf(request.getParameter("page"));// 获得页数
        int limit = Integer.valueOf(request.getParameter("limit"));// 获得每页显示条数
        Teacher teacher=(Teacher) session.getAttribute("teacher");
        ReplyGroupTeacher replyGroupTeacher=replyGroupTeacherService.queryReplyGroupTeacherByTid(teacher.getTid());
        int gid=replyGroupTeacher.getGid();
        List<ReplyStudentVo> replyStudentVoList=replyGroupStudentService.queryPageReplyStudentVo(gid,page,limit);
        // 分页查询
        int size = replyGroupStudentService.queryCountReplyStudentVoByGid(gid);
        // 返回数据
        map.put("code",0);
        map.put("msg","");
        map.put("count",size);
        map.put("data",replyStudentVoList);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/goDReplyGroupTeacher", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goDReplyGroupTeacher(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/reply/dreplyGroupTeacher");
        return mv;
    }

    @RequestMapping(value = "/dReplyGroupTeacherGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object dReplyGroupTeacherGetAllJson(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        int page = Integer.valueOf(request.getParameter("page"));// 获得页数
        int limit = Integer.valueOf(request.getParameter("limit"));// 获得每页显示条数
        Teacher teacher=(Teacher) session.getAttribute("teacher");
        ReplyGroupTeacher replyGroupTeacher=replyGroupTeacherService.queryReplyGroupTeacherByTid(teacher.getTid());
        int gid=replyGroupTeacher.getGid();
        List<ReplyTeacherVo> replyTeacherVoList = replyGroupTeacherService.queryPageReplyTeacherVo(gid, page, limit);
        // 分页查询
        int size = replyGroupTeacherService.queryCountReplyTeacherVoByGid(gid);
        // 返回数据
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", size);
        map.put("data", replyTeacherVoList);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/goReplyReview", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goReplyReview(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/reply/replyReview");
        return mv;
    }

    @RequestMapping(value = "/goReviewStudent", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goReviewStudent(HttpServletRequest request,HttpSession session){
        ModelAndView mv = new ModelAndView();
        String sid =request.getParameter("sid");
        mv.setViewName("/view/reply/reviewStudent");
        mv.addObject("sid",sid);
        return mv;
    }

    @RequestMapping(value = "/addReview", method = RequestMethod.POST)
    @ResponseBody
    public Object addReview(HttpServletRequest request, HttpSession session){
        String sid=request.getParameter("sid");
        int openTopicScore=Integer.valueOf(request.getParameter("openTopicScore"));
        int midScore=Integer.valueOf(request.getParameter("midScore"));
        int graduateScore=Integer.valueOf(request.getParameter("graduateScore"));
        Teacher teacher=(Teacher) session.getAttribute("teacher");
        String tid=teacher.getTid();
        ReplyReview replyReview=new ReplyReview();
        replyReview.setSid(sid);
        replyReview.setTid(tid);
        replyReview.setOpenTopicScore(openTopicScore);
        replyReview.setMidScore(midScore);
        replyReview.setGraduateScore(graduateScore);
        int i=replyReviewService.insertReplyReview(replyReview);
        if(i>0){
            return JSONObject.toJSON(KitUtil.returnMap("200", StaticFinalVar.ADD_OK));
        }else {
            return JSONObject.toJSON(KitUtil.returnMap("101",StaticFinalVar.ADD_ERR));
        }
    }

    @RequestMapping(value = "/goLookStudentReplyScore", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goLookStudentReplyScore(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/reply/lookStudentReplyScore");
        return mv;
    }
    @RequestMapping(value = "/groupStudentScoreGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object groupStudentScoreGetAllJson(HttpServletRequest request, HttpSession session){
        Map<String,Object> map = new HashMap<String,Object>();
        int page = Integer.valueOf(request.getParameter("page"));// 获得页数
        int limit = Integer.valueOf(request.getParameter("limit"));// 获得每页显示条数
        Teacher teacher=(Teacher) session.getAttribute("teacher");
        ReplyGroupTeacher replyGroupTeacher=replyGroupTeacherService.queryReplyGroupTeacherByTid(teacher.getTid());
        int gid=replyGroupTeacher.getGid();
        List<StudentReplyScoreVo> studentReplyScoreVoList=studentReplyScoreService.queryPageStuentReplyScoreVoByGid(gid,page,limit);
        // 分页查询
        int size = studentReplyScoreService.queryCountStuentReplyScoreVoByGid(gid);
        // 返回数据
        map.put("code",0);
        map.put("msg","");
        map.put("count",size);
        map.put("data",studentReplyScoreVoList);
        return JSONObject.toJSON(map);
    }


    @RequestMapping(value = "/goLookAllReplyGroup", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goLookAllReplyGroup(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/reply/lookAllReplyGroup");
        return mv;
    }

    @RequestMapping(value = "/goAReplyGroupTeacher", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goAReplyGroupTeacher(HttpServletRequest request,HttpSession session){
        ModelAndView mv = new ModelAndView();
        int groupId=Integer.valueOf(request.getParameter("id"));
        session.setAttribute("groupId2",groupId);
        mv.setViewName("/view/reply/areplyGroupTeacher");
        return mv;
    }

    @RequestMapping(value = "/AReplyGroupTeacherGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object AReplyGroupTeacherGetAllJson(HttpServletRequest request, HttpSession session){
        Map<String,Object> map = new HashMap<String,Object>();
        int page = Integer.valueOf(request.getParameter("page"));// 获得页数
        int limit = Integer.valueOf(request.getParameter("limit"));// 获得每页显示条数
        int gid=new Integer(session.getAttribute("groupId2").toString());
        List<ReplyTeacherVo> replyTeacherVoList=replyGroupTeacherService.queryPageReplyTeacherVo(gid,page,limit);
        // 分页查询
        int size = replyGroupTeacherService.queryCountReplyTeacherVoByGid(gid);
        // 返回数据
        map.put("code",0);
        map.put("msg","");
        map.put("count",size);
        map.put("data",replyTeacherVoList);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/goAReplyGroupStudent", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goAReplyGroupStudent(HttpServletRequest request,HttpSession session){
        ModelAndView mv = new ModelAndView();
        int groupId=Integer.valueOf(request.getParameter("id"));
        session.setAttribute("groupId2",groupId);
        mv.setViewName("/view/reply/areplyGroupStudent");
        return mv;
    }

    @RequestMapping(value = "/AReplyGroupStudentGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object AReplyGroupStudentGetAllJson(HttpServletRequest request, HttpSession session){
        Map<String,Object> map = new HashMap<String,Object>();
        int page = Integer.valueOf(request.getParameter("page"));// 获得页数
        int limit = Integer.valueOf(request.getParameter("limit"));// 获得每页显示条数
        int gid=new Integer(session.getAttribute("groupId2").toString());
        List<ReplyStudentVo> replyStudentVoList=replyGroupStudentService.queryPageReplyStudentVo(gid,page,limit);
        // 分页查询
        int size = replyGroupStudentService.queryCountReplyStudentVoByGid(gid);
        // 返回数据
        map.put("code",0);
        map.put("msg","");
        map.put("count",size);
        map.put("data",replyStudentVoList);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/goReplySet", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goReplySet(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/reply/replySet");
        return mv;
    }

    @RequestMapping(value = "/allReplyGroupGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object allReplyGroupGetAllJson(HttpServletRequest request, HttpSession session){
        Map<String,Object> map = new HashMap<String,Object>();
        int page = Integer.valueOf(request.getParameter("page"));// 获得页数
        int limit = Integer.valueOf(request.getParameter("limit"));// 获得每页显示条数
        List<ReplyGroupVo> replyGroupVoList=replyGroupService.queryPageReplyGroupVo(page,limit);
        // 分页查询
        int size = replyGroupService.queryCountReplyGroupVo();
        // 返回数据
        map.put("code",0);
        map.put("msg","");
        map.put("count",size);
        map.put("data",replyGroupVoList);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/goAddReplyGroup", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goAddReplyGroup(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/reply/addReplyGroup");
        return mv;
    }

    @RequestMapping(value = "/addReplyGroup", method = RequestMethod.POST)
    @ResponseBody
    public Object addReplyGroup(HttpServletRequest request,HttpSession session){
        String groupName= request.getParameter("groupName");
        String groupLeaderTid=request.getParameter("groupLeaderTid");
        ReplyGroup replyGroup=new ReplyGroup();
        replyGroup.setGroupName(groupName);
        replyGroup.setGroupLeaderTid(groupLeaderTid);
        int i=replyGroupService.insertReplyGroup(replyGroup);
        if(i>0){
            return JSONObject.toJSON(KitUtil.returnMap("200", StaticFinalVar.ADD_OK));
        }else {
            return JSONObject.toJSON(KitUtil.returnMap("101",StaticFinalVar.ADD_ERR));
        }
    }

    @RequestMapping(value = "/goAddReplyGroupStudent", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goAddReplyGroupStudent(HttpServletRequest request,HttpSession session){
        ModelAndView mv = new ModelAndView();
        int groupId=Integer.valueOf(request.getParameter("id"));
        session.setAttribute("groupId1",groupId);
        mv.setViewName("/view/reply/addReplyGroupStudent");
        return mv;
    }

    @RequestMapping(value = "replyGroupStudentGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object replyGroupStudentGetAllJson(HttpServletRequest request, HttpSession session){
        Map<String,Object> map = new HashMap<String,Object>();
        List<ReplyStudentVo> replyStudentVoList=replyGroupStudentService.queryReplyStudentVo();
        List<ReplyStudentVo> replyStudentVoList1=new ArrayList<ReplyStudentVo>();
        for (ReplyStudentVo list2:replyStudentVoList) {
            ReplyGroupStudent replyGroupStudent=replyGroupStudentService.queryReplyGroupStudentBySid(list2.getSid());
            if(replyGroupStudent!=null){
            }else{
                replyStudentVoList1.add(list2);
            }
        }
        map.put("code",0);
        map.put("msg","");
        map.put("data",replyStudentVoList1);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/addReplyGroupStudent", method = RequestMethod.POST)
    @ResponseBody
    public Object addReplyGroupStudent(HttpServletRequest request,HttpSession session){
        String sid=request.getParameter("sid");
        int groupId=new Integer(session.getAttribute("groupId1").toString());
        ReplyGroupStudent replyGroupStudent=new ReplyGroupStudent();
        replyGroupStudent.setSid(sid);
        replyGroupStudent.setGid(groupId);
        ReplyGroup replyGroup=replyGroupService.queryById(groupId);
        ReplyGroup replyGroup1=new ReplyGroup();
        replyGroup1.setId(groupId);
        replyGroup1.setGroupStudentNumber(replyGroup.getGroupStudentNumber()+1);
        int j=replyGroupService.updateReplyGroup(replyGroup1);
        int i=replyGroupStudentService.insertReplyGroupStudent(replyGroupStudent);
        if(i>0){
            return JSONObject.toJSON(KitUtil.returnMap("200", StaticFinalVar.ADD_OK));
        }else {
            return JSONObject.toJSON(KitUtil.returnMap("101",StaticFinalVar.ADD_ERR));
        }
    }

    @RequestMapping(value = "/addAllReplyGroupStudent", method = RequestMethod.POST)
    @ResponseBody
    public Object addAllReplyGroupStudent(@RequestBody ReplyStudentVo[] replyStudentVos, HttpServletRequest request, HttpSession session){
        int groupId=new Integer(session.getAttribute("groupId1").toString());
        ReplyGroup replyGroup=replyGroupService.queryById(groupId);
        ReplyGroup replyGroup1=new ReplyGroup();
        replyGroup1.setId(groupId);
        replyGroup1.setGroupStudentNumber(replyGroup.getGroupStudentNumber()+replyStudentVos.length);
        int j=replyGroupService.updateReplyGroup(replyGroup1);
        int i=0;
        for (ReplyStudentVo list:replyStudentVos) {
            ReplyGroupStudent replyGroupStudent=new ReplyGroupStudent();
            replyGroupStudent.setSid(list.getSid());
            replyGroupStudent.setGid(groupId);
            i=replyGroupStudentService.insertReplyGroupStudent(replyGroupStudent);
        }
        if(i>0){
            return JSONObject.toJSON(KitUtil.returnMap("200", StaticFinalVar.ADD_OK));
        }else {
            return JSONObject.toJSON(KitUtil.returnMap("101",StaticFinalVar.ADD_ERR));
        }
    }

    @RequestMapping(value = "/goAddReplyGroupTeacher", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goAddReplyGroupTeacher(HttpServletRequest request,HttpSession session){
        ModelAndView mv = new ModelAndView();
        int groupId=Integer.valueOf(request.getParameter("id"));
        session.setAttribute("groupId1",groupId);
        mv.setViewName("/view/reply/addReplyGroupTeacher");
        return mv;
    }

    @RequestMapping(value = "replyGroupTeacherGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object replyGroupTeacherGetAllJson(HttpServletRequest request, HttpSession session){
        Map<String,Object> map = new HashMap<String,Object>();
        List<ReplyTeacherVo> replyTeacherVoList=replyGroupTeacherService.queryReplyTeacherVo();
        List<ReplyTeacherVo> replyTeacherVoList1=new ArrayList<ReplyTeacherVo>();
            for (ReplyTeacherVo list2:replyTeacherVoList) {
                ReplyGroupTeacher replyGroupTeacher=replyGroupTeacherService.queryReplyGroupTeacherByTid(list2.getTid());
                if(replyGroupTeacher!=null){
                }else{
                    replyTeacherVoList1.add(list2);
                }
            }
            map.put("code",0);
            map.put("msg","");
            map.put("data",replyTeacherVoList1);
        return JSONObject.toJSON(map);
    }


    @RequestMapping(value = "/addReplyGroupTeacher", method = RequestMethod.POST)
    @ResponseBody
    public Object addReplyGroupTeacher(HttpServletRequest request,HttpSession session){
        String tid=request.getParameter("tid");
        int groupId=new Integer(session.getAttribute("groupId1").toString());
        ReplyGroupTeacher replyGroupTeacher=new ReplyGroupTeacher();
        replyGroupTeacher.setTid(tid);
        replyGroupTeacher.setGid(groupId);
        ReplyGroup replyGroup=replyGroupService.queryById(groupId);
        ReplyGroup replyGroup1=new ReplyGroup();
        replyGroup1.setId(groupId);
        replyGroup1.setGroupTeacherNumber(replyGroup.getGroupTeacherNumber()+1);
        int j=replyGroupService.updateReplyGroup(replyGroup1);
        int i=replyGroupTeacherService.insertReplyGroupTeacher(replyGroupTeacher);
        if(i>0){
            return JSONObject.toJSON(KitUtil.returnMap("200", StaticFinalVar.ADD_OK));
        }else {
            return JSONObject.toJSON(KitUtil.returnMap("101",StaticFinalVar.ADD_ERR));
        }
    }

    @RequestMapping(value = "/addAllReplyGroupTeacher", method = RequestMethod.POST)
    @ResponseBody
    public Object addAllReplyGroupTeacher(@RequestBody ReplyTeacherVo[] replyTeacherVos, HttpServletRequest request, HttpSession session){
        int groupId=new Integer(session.getAttribute("groupId1").toString());
        ReplyGroup replyGroup=replyGroupService.queryById(groupId);
        ReplyGroup replyGroup1=new ReplyGroup();
        replyGroup1.setId(groupId);
        replyGroup1.setGroupTeacherNumber(replyGroup.getGroupTeacherNumber()+replyTeacherVos.length);
        int j=replyGroupService.updateReplyGroup(replyGroup1);
        int i=0;
        for (ReplyTeacherVo list:replyTeacherVos) {
            ReplyGroupTeacher replyGroupTeacher=new ReplyGroupTeacher();
            replyGroupTeacher.setTid(list.getTid());
            replyGroupTeacher.setGid(groupId);
            i=replyGroupTeacherService.insertReplyGroupTeacher(replyGroupTeacher);
        }
        if(i>0){
            return JSONObject.toJSON(KitUtil.returnMap("200", StaticFinalVar.ADD_OK));
        }else {
            return JSONObject.toJSON(KitUtil.returnMap("101",StaticFinalVar.ADD_ERR));
        }
    }

    @RequestMapping(value = "/goReviewManagement", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goReviewManagement(HttpServletRequest request,HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/reply/reviewManagement");
        return mv;
    }

    @RequestMapping(value = "reviewManagementGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object reviewManagementGetAllJson(HttpServletRequest request, HttpSession session){
        Map<String,Object> map = new HashMap<String,Object>();
        int page = Integer.valueOf(request.getParameter("page"));// 获得页数
        int limit = Integer.valueOf(request.getParameter("limit"));// 获得每页显示条数
        Teacher teacher=(Teacher) session.getAttribute("teacher");
        ReplyGroupTeacher replyGroupTeacher=replyGroupTeacherService.queryReplyGroupTeacherByTid(teacher.getTid());
        List<ReviewVo> reviewVoList=replyReviewService.queryPageReviewVoByGid(replyGroupTeacher.getGid(),page,limit);
        // 分页查询
        int size = replyReviewService.queryCountReviewVoByGid(replyGroupTeacher.getGid());
        // 返回数据
        map.put("code",0);
        map.put("msg","");
        map.put("count",size);
        map.put("data",reviewVoList);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/entryReview", method = RequestMethod.POST)
    @ResponseBody
    public Object entryReview(HttpServletRequest request,HttpSession session){
        int id =Integer.valueOf(request.getParameter("id"));
        ReplyReview replyReview=replyReviewService.queryById(id);
        StudentReplyScore studentReplyScore=studentReplyScoreService.queryStudentReplyScoreBySid(replyReview.getSid());
        int j=0;
        if(studentReplyScore==null){
            StudentReplyScore studentReplyScore1=new StudentReplyScore();
            studentReplyScore1.setSid(replyReview.getSid());
            studentReplyScore1.setOpenTopicScore(replyReview.getOpenTopicScore());
            studentReplyScore1.setMidScore(replyReview.getMidScore());
            studentReplyScore1.setGraduateScore(replyReview.getGraduateScore());
            j=studentReplyScoreService.insertStudentReplyScore(studentReplyScore1);
        }else{
            StudentReplyScore studentReplyScore1=new StudentReplyScore();
            studentReplyScore1.setSid(replyReview.getSid());
            studentReplyScore1.setOpenTopicScore((studentReplyScore.getOpenTopicScore()+replyReview.getOpenTopicScore())/2);
            studentReplyScore1.setMidScore((studentReplyScore.getMidScore()+replyReview.getMidScore())/2);
            studentReplyScore1.setGraduateScore((studentReplyScore.getGraduateScore()+replyReview.getGraduateScore())/2);
            j=studentReplyScoreService.insertStudentReplyScore(studentReplyScore1);
        }
        if(j>0){
            int i=replyReviewService.deleteById(id);
            return JSONObject.toJSON(KitUtil.returnMap("200", StaticFinalVar.ADD_OK));
        }else {
            return JSONObject.toJSON(KitUtil.returnMap("101",StaticFinalVar.ADD_ERR));
        }
    }
}
