package com.gdms.controller.topic;

import cc.openkit.common.KitUtil;
import com.alibaba.fastjson.JSONObject;
import com.gdms.model.*;
import com.gdms.service.reply.ReplyGroupService;
import com.gdms.service.topic.TeacherTopicService;
import com.gdms.service.topic.TopicApplyService;
import com.gdms.service.user.TeacherService;
import com.gdms.util.InData;
import com.gdms.util.OutData;
import com.gdms.util.StaticFinalVar;
import com.gdms.vo.AdviseStudentVo;
import com.gdms.vo.StudentTopicVo;
import net.sf.jsqlparser.statement.select.Top;
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
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/topic")
public class TopicController {
    private Logger log = Logger.getLogger(TopicController.class);

    @Resource
    TopicApplyService topicApplyService;

    @Resource
    TeacherTopicService teacherTopicService;

    @Resource
    TeacherService teacherService;

    @Resource
    ReplyGroupService replyGroupService;

    @RequestMapping(value = "/goApplyByOneself", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goApplyByOneself(HttpSession session){
        ModelAndView mv = new ModelAndView();
        Student student=(Student) session.getAttribute("student");
        TopicApply topicApply= topicApplyService.queryTopicApplyBySid(student.getSid());
        if(topicApply!=null){
            mv.addObject("status",101);
        }else{
            mv.addObject("status",200);
        }
        mv.setViewName("/view/topic/applyTopicByOneself");
        return mv;
    }

    @RequestMapping(value = "/addTopicByOnself", method = RequestMethod.POST)
    @ResponseBody
    public Object addTopicByOnself(HttpServletRequest request,HttpSession session){
        String topicName=request.getParameter("topicName");
        int type=0;
        String attachmentName=request.getParameter("attachmentName");
        String attachmentUrl=request.getParameter("attachmentUrl");
        Student student=(Student) session.getAttribute("student");
        String sid=student.getSid();
        TopicApply topicApply=new TopicApply();
        topicApply.setTopicName(topicName);
        topicApply.setType(type);
        topicApply.setAttachmentName(attachmentName);
        topicApply.setAttachmentUrl(attachmentUrl);
        topicApply.setSid(sid);
        int i=topicApplyService.insertTopicApply(topicApply);
        if(i>0){
            return JSONObject.toJSON(KitUtil.returnMap("200", StaticFinalVar.ADD_OK));
        }else {
            return JSONObject.toJSON(KitUtil.returnMap("101",StaticFinalVar.ADD_ERR));
        }
    }

    @RequestMapping(value = "/goApplyByOther", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goApplyByOther(HttpSession session){
        ModelAndView mv = new ModelAndView();
        Student student=(Student) session.getAttribute("student");
        Teacher teacher=teacherService.queryById(student.getAdviserid());
        TopicApply topicApply= topicApplyService.queryTopicApplyBySid(student.getSid());
        if(topicApply!=null){
            mv.addObject("status",101);
        }else{
            mv.addObject("status",200);
        }
        List<TeacherTopic> teacherTopicList=teacherTopicService.queryTeacherTopicByTid(teacher.getTid());
        mv.addObject("teacherTopicList",teacherTopicList);
        mv.setViewName("view/topic/applyTopicByOther");
        return mv;
    }

    @RequestMapping(value = "/addTopicByOther", method = RequestMethod.POST)
    @ResponseBody
    public Object addTopicByOther(HttpServletRequest request,HttpSession session){
        int topicName1=Integer.valueOf(request.getParameter("topicName"));
        TeacherTopic teacherTopic=teacherTopicService.queryById(topicName1);
        String topicName=teacherTopic.getTopicName();
        int type=1;
        String attachmentName=request.getParameter("attachmentName");
        String attachmentUrl=request.getParameter("attachmentUrl");
        Student student=(Student) session.getAttribute("student");
        String sid=student.getSid();
        TopicApply topicApply=new TopicApply();
        topicApply.setTopicName(topicName);
        topicApply.setType(type);
        topicApply.setAttachmentName(attachmentName);
        topicApply.setAttachmentUrl(attachmentUrl);
        topicApply.setSid(sid);
        int i=topicApplyService.insertTopicApply(topicApply);
        if(i>0){
            return JSONObject.toJSON(KitUtil.returnMap("200", StaticFinalVar.ADD_OK));
        }else {
            return JSONObject.toJSON(KitUtil.returnMap("101",StaticFinalVar.ADD_ERR));
        }
    }

    @RequestMapping(value = "/goLookApplyResult", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goLookApplyResult(HttpSession session){
        ModelAndView mv = new ModelAndView();
        Student student=(Student) session.getAttribute("student");
        TopicApply topicApply=topicApplyService.queryTopicApplyBySid(student.getSid());
        mv.addObject("topicApply",topicApply);
        mv.setViewName("view/topic/lookApplyResult");
        return mv;
    }

    @RequestMapping(value = "/cancelApply", method = RequestMethod.POST)
    @ResponseBody
    public Object cancelApply(HttpServletRequest request,HttpSession session){
        Student student=(Student) session.getAttribute("student");
        int i=topicApplyService.deleteTopicApplyBySid(student.getSid());
        if(i>0){
            return JSONObject.toJSON(KitUtil.returnMap("200", StaticFinalVar.DEL_OK));
        }else {
            return JSONObject.toJSON(KitUtil.returnMap("101",StaticFinalVar.DEL_ERR));
        }
    }


    @RequestMapping(value = "/goLookStudentTopic", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goLookStudentTopic(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("view/topic/lookStudentTopic");
        return mv;
    }

    @RequestMapping(value = "/studentTopicGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object studentTopicGetAllJson(HttpServletRequest request,HttpSession session){
        Map<String,Object> map = new HashMap<String,Object>();
        int page = Integer.valueOf(request.getParameter("page"));// 获得页数
        int limit = Integer.valueOf(request.getParameter("limit"));// 获得每页显示条数
        Teacher teacher=(Teacher) session.getAttribute("teacher");
        List<StudentTopicVo> studentTopicVoList=topicApplyService.queryPageStudentTopicVo(teacher.getId(),page,limit);
        // 分页查询
        int size = topicApplyService.queryCountStudentTopicVo(teacher.getId());
        // 返回数据
        map.put("code",0);
        map.put("msg","");
        map.put("count",size);
        map.put("data",studentTopicVoList);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/selectFileUrl", method = RequestMethod.POST)
    @ResponseBody
    public Object selectFileUrl(HttpServletRequest request, @RequestBody InData inData){
        Map<String, Object> returnmap1 = new HashMap<String, Object>();
        Map<String, Object> map = inData.getInmap();
        Integer id =new Integer(map.get("id").toString());
        TopicApply topicApply= topicApplyService.queryById(id);
        returnmap1.put("fileUrl",topicApply.getAttachmentUrl());
        return JSONObject.toJSON(OutData.outData(StaticFinalVar.DOWNLOAD_OK,returnmap1,200));
    }

    @RequestMapping(value = "/goUploadTopic", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goUploadTopic(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("view/topic/uploadTopic");
        return mv;
    }

    @RequestMapping(value = "/addUploadTopic", method = RequestMethod.POST)
    @ResponseBody
    public Object addUploadTopic(HttpServletRequest request,HttpSession session){
        Teacher teacher=(Teacher) session.getAttribute("teacher");
        String topicName= request.getParameter("topicName");
        TeacherTopic teacherTopic=new TeacherTopic();
        teacherTopic.setTopicName(topicName);
        teacherTopic.setTid(teacher.getTid());
        int i=teacherTopicService.insertTeacherTopic(teacherTopic);
        if(i>0){
            return JSONObject.toJSON(KitUtil.returnMap("200", StaticFinalVar.ADD_OK));
        }else {
            return JSONObject.toJSON(KitUtil.returnMap("101",StaticFinalVar.ADD_ERR));
        }
    }

    @RequestMapping(value = "/goUploadTopicManagement", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goUploadTopicManagement(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("view/topic/uploadTopicManagement");
        return mv;
    }

    @RequestMapping(value = "/UploadTopicGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object UploadTopicGetAllJson(HttpServletRequest request,HttpSession session){
        Map<String,Object> map = new HashMap<String,Object>();
        int page = Integer.valueOf(request.getParameter("page"));// 获得页数
        int limit = Integer.valueOf(request.getParameter("limit"));// 获得每页显示条数
        Teacher teacher=(Teacher) session.getAttribute("teacher");
        List<TeacherTopic> teacherTopicList=teacherTopicService.queryPageTeacherTopic(teacher.getTid(),page,limit);
        // 分页查询
        int size = teacherTopicService.queryCountTeacherTopic(teacher.getTid());
        // 返回数据
        map.put("code",0);
        map.put("msg","");
        map.put("count",size);
        map.put("data",teacherTopicList);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/delUploadTopic", method = RequestMethod.POST)
    @ResponseBody
    public Object delUploadTopic(HttpServletRequest request,HttpSession session){
        int id= Integer.valueOf(request.getParameter("id"));
        int i=teacherTopicService.deleteById(id);
        if(i>0){
            return JSONObject.toJSON(KitUtil.returnMap("200", StaticFinalVar.DEL_OK));
        }else {
            return JSONObject.toJSON(KitUtil.returnMap("101",StaticFinalVar.DEL_ERR));
        }
    }

    @RequestMapping(value = "/goTopicManagement", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goTopicManagement(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("view/topic/topicManagement");
        return mv;
    }

    @RequestMapping(value = "/TopicManagementGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object TopicManagementGetAllJson(HttpServletRequest request,HttpSession session){
        Map<String,Object> map = new HashMap<String,Object>();
        int page = Integer.valueOf(request.getParameter("page"));// 获得页数
        int limit = Integer.valueOf(request.getParameter("limit"));// 获得每页显示条数
        Teacher teacher=(Teacher) session.getAttribute("teacher");
        ReplyGroup replyGroup=replyGroupService.queryReplyGroupByGroupLeaderId(teacher.getTid());
        List<StudentTopicVo> studentTopicVoList=topicApplyService.queryPageStudentTopicVoByGid(replyGroup.getId(),page,limit);
        // 分页查询
        int size = topicApplyService.queryCountStudentTopicVoByGid(replyGroup.getId());
        // 返回数据
        map.put("code",0);
        map.put("msg","");
        map.put("count",size);
        map.put("data",studentTopicVoList);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/approval", method = RequestMethod.POST)
    @ResponseBody
    public Object approval(HttpServletRequest request,HttpSession session){
        int id= Integer.valueOf(request.getParameter("id"));
        TopicApply topicApply=new TopicApply();
        topicApply.setId(id);
        topicApply.setPassSituation(1);
        int i=topicApplyService.updateTopicApplyById(topicApply);
        if(i>0){
            return JSONObject.toJSON(KitUtil.returnMap("200", StaticFinalVar.UPDATE_OK));
        }else {
            return JSONObject.toJSON(KitUtil.returnMap("101",StaticFinalVar.UPDATE_ERR));
        }
    }


    @RequestMapping(value = "/unapproval", method = RequestMethod.POST)
    @ResponseBody
    public Object unapproval(HttpServletRequest request,HttpSession session){
        int id= Integer.valueOf(request.getParameter("id"));
        TopicApply topicApply=new TopicApply();
        topicApply.setId(id);
        topicApply.setPassSituation(2);
        int i=topicApplyService.updateTopicApplyById(topicApply);
        if(i>0){
            return JSONObject.toJSON(KitUtil.returnMap("200", StaticFinalVar.UPDATE_OK));
        }else {
            return JSONObject.toJSON(KitUtil.returnMap("101",StaticFinalVar.UPDATE_ERR));
        }
    }

    @RequestMapping(value = "/goLookAllStudentTopic", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goLookAllStudentTopic(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("view/topic/lookAllStudentTopic");
        return mv;
    }

    @RequestMapping(value = "/allTopicGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object allTopicGetAllJson(HttpServletRequest request,HttpSession session){
        Map<String,Object> map = new HashMap<String,Object>();
        int page = Integer.valueOf(request.getParameter("page"));// 获得页数
        int limit = Integer.valueOf(request.getParameter("limit"));// 获得每页显示条数
        List<StudentTopicVo> studentTopicVoList=topicApplyService.queryPageAllStudentTopicVo(page,limit);
        // 分页查询
        int size = topicApplyService.queryCountAllStudentTopicVo();
        // 返回数据
        map.put("code",0);
        map.put("msg","");
        map.put("count",size);
        map.put("data",studentTopicVoList);
        return JSONObject.toJSON(map);
    }

}
