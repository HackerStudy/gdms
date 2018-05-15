package com.gdms.controller.score;

import cc.openkit.common.KitUtil;
import com.alibaba.fastjson.JSONObject;
import com.gdms.model.*;
import com.gdms.service.advise.AdviseTAndSService;
import com.gdms.service.reply.ReplyGroupStudentService;
import com.gdms.service.reply.ReplyGroupTeacherService;
import com.gdms.service.reply.StudentReplyScoreService;
import com.gdms.service.score.AdviserScoreService;
import com.gdms.service.score.PaperScoreService;
import com.gdms.service.score.ReplyScoreService;
import com.gdms.service.score.StudentScoreService;
import com.gdms.util.InData;
import com.gdms.util.StaticFinalVar;
import com.gdms.vo.*;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/score")
public class ScoreController {
    private Logger log = Logger.getLogger(ScoreController.class);

    @Resource
    StudentScoreService studentScoreService;

    @Resource
    AdviserScoreService adviserScoreService;


    @Resource
    AdviseTAndSService adviseTAndSService;

    @Resource
    ReplyGroupTeacherService replyGroupTeacherService;

    @Resource
    PaperScoreService paperScoreService;

    @Resource
    ReplyGroupStudentService replyGroupStudentService;

    @Resource
    StudentReplyScoreService studentReplyScoreService;

    @Resource
    ReplyScoreService replyScoreService;

    @RequestMapping(value = "/goLookOneselfScore", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goLookStayReplyGroup(HttpSession session){
        ModelAndView mv = new ModelAndView();
        Student student=(Student) session.getAttribute("student");
        StudentScore studentScore=studentScoreService.queryStudentScoreBySid(student.getSid());
        mv.addObject("studentScore",studentScore);
        mv.setViewName("/view/score/lookOneselfScore");
        return mv;
    }

    @RequestMapping(value = "/goLookStudentScore", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goLookStudentScore(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/score/lookStudentScore");
        return mv;
    }

    @RequestMapping(value = "/haveStudentScoreGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object haveStudentScoreGetAllJson(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        int page = Integer.valueOf(request.getParameter("page"));// 获得页数
        int limit = Integer.valueOf(request.getParameter("limit"));// 获得每页显示条数
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        List<StudentScoreVo> studentScoreVoList = studentScoreService.queryPageStudentScoreVoByTid(teacher.getTid(), page, limit);
        // 分页查询
        int size = studentScoreService.queryCountStudentScoreVoByTid(teacher.getTid());
        // 返回数据
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", size);
        map.put("data", studentScoreVoList);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/goEntryScoreByATeacher", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goEntryScoreByATeacher(HttpSession session){
        ModelAndView mv = new ModelAndView();
        Teacher teacher=(Teacher) session.getAttribute("teacher");
        List<AdviserScore> adviserScoreList=adviserScoreService.queryAdviserScoreByTid(teacher.getTid());
        List<AdviseTAndS> adviseTAndSList=adviseTAndSService.queryAdviseTAndSByTid(teacher.getTid());
        if(adviserScoreList.size()>0) {
            for (AdviseTAndS list2:adviseTAndSList) {
                int i=0;
                for (AdviserScore  list:adviserScoreList){
                    if(list.getSid().equals(list2.getSid())){
                        i=1;
                    }else{

                    }
                }
                if(i==1){

                }else{
                    AdviserScore adviserScore=new AdviserScore();
                    adviserScore.setTid(teacher.getTid());
                    adviserScore.setSid(list2.getSid());
                    adviserScore.setAdviserScore(0);
                    int j=adviserScoreService.insertAdviseScore(adviserScore);
                }
            }
        }else{
            for (AdviseTAndS list1:adviseTAndSList) {
                AdviserScore adviserScore=new AdviserScore();
                adviserScore.setTid(teacher.getTid());
                adviserScore.setSid(list1.getSid());
                adviserScore.setAdviserScore(0);
                int j=adviserScoreService.insertAdviseScore(adviserScore);
            }
        }
        mv.setViewName("/view/score/entryScoreByATeacher");
        return mv;
    }

    @RequestMapping(value = "/entryAdviserScoreGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object entryAdviserScoreGetAllJson(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        int page = Integer.valueOf(request.getParameter("page"));// 获得页数
        int limit = Integer.valueOf(request.getParameter("limit"));// 获得每页显示条数
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        List<EntryAdviserScore> entryAdviserScoreList = adviserScoreService.queryPageEntryAdviserScoreByTid(teacher.getTid(), page, limit);
        // 分页查询
        int size = adviserScoreService.queryCountEntryAdviserScoreByTid(teacher.getTid());
        // 返回数据
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", size);
        map.put("data", entryAdviserScoreList);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/updateAdviserScore", method = RequestMethod.POST)
    @ResponseBody
    public Object updateAdviserScore(@RequestBody InData inData,HttpServletRequest request, HttpSession session){
        Map<String, Object> map = inData.getInmap();
        String sid=(String) map.get("sid");
        Integer adviserScore=new Integer(map.get("adviserScore").toString());
        AdviserScore adviserScore1=new AdviserScore();
        adviserScore1.setSid(sid);
        adviserScore1.setAdviserScore(adviserScore);
        int i= adviserScoreService.updateAdviseScoreBySid(adviserScore1) ;
        if(i>0){
            return JSONObject.toJSON(KitUtil.returnMap("200", StaticFinalVar.UPDATE_OK));
        }else {
            return JSONObject.toJSON(KitUtil.returnMap("101",StaticFinalVar.UPDATE_ERR));
        }
    }

    @RequestMapping(value = "/goEntryScoreByRTeacher", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goEntryScoreByRTeacher(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/score/entryScoreByRTeacher");
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

    @RequestMapping(value = "/addReplyScore", method = RequestMethod.POST)
    @ResponseBody
    public Object addReplyScore(HttpServletRequest request, HttpSession session){
        String sid=request.getParameter("sid");
        String openTopicScore=request.getParameter("openTopicScore");
        String midScore=request.getParameter("midScore");
        String graduateScore=request.getParameter("graduateScore");
        Integer replyScore1=(Integer.valueOf(openTopicScore)+Integer.valueOf(midScore)+Integer.valueOf(graduateScore))/3;
        ReplyScore replyScore=new ReplyScore();
        replyScore.setSid(sid);
        replyScore.setOpenTopicScore(Integer.valueOf(openTopicScore));
        replyScore.setMidScore(Integer.valueOf(midScore));
        replyScore.setGraduateScore(Integer.valueOf(graduateScore));
        replyScore.setReplyScore(replyScore1);
        replyScore.setEntryStatus(1);
        int i= replyScoreService.insertReplyScore(replyScore);
        if(i>0){
            return JSONObject.toJSON(KitUtil.returnMap("200", StaticFinalVar.UPDATE_OK));
        }else {
            return JSONObject.toJSON(KitUtil.returnMap("101",StaticFinalVar.UPDATE_ERR));
        }
    }

    @RequestMapping(value = "/goEntryPaperScore", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goEntryPaperScore(HttpSession session){
        Teacher teacher=(Teacher) session.getAttribute("teacher");
        ReplyGroupTeacher replyGroupTeacher=replyGroupTeacherService.queryReplyGroupTeacherByTid(teacher.getTid());
        int gid=replyGroupTeacher.getGid();
        List<PaperScore> paperScoreList=paperScoreService.queryAll();
        List<ReplyGroupStudent> replyGroupStudentList=replyGroupStudentService.queryReplyGroupStudentByGid(gid);
        if(paperScoreList.size()>0) {
            for (ReplyGroupStudent list2:replyGroupStudentList) {
                int i=0;
                for (PaperScore  list:paperScoreList){
                    if(list.getSid().equals(list2.getSid())){
                        i=1;
                    }else{

                    }
                }
                if(i==1){

                }else{
                    PaperScore paperScore=new PaperScore();
                    paperScore.setSid(list2.getSid());
                    paperScore.setPaperScore(0);
                    int j=paperScoreService.insertPaperScore(paperScore);
                }
            }
        }else{
            for (ReplyGroupStudent list1:replyGroupStudentList) {
                PaperScore paperScore=new PaperScore();
                paperScore.setSid(list1.getSid());
                paperScore.setPaperScore(0);
                int j=paperScoreService.insertPaperScore(paperScore);
            }
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/score/entryPaperScore");
        return mv;
    }

    @RequestMapping(value = "/entryPaperScoreGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object entryPaperScoreGetAllJson(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        int page = Integer.valueOf(request.getParameter("page"));// 获得页数
        int limit = Integer.valueOf(request.getParameter("limit"));// 获得每页显示条数
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        ReplyGroupTeacher replyGroupTeacher=replyGroupTeacherService.queryReplyGroupTeacherByTid(teacher.getTid());
        int gid=replyGroupTeacher.getGid();
        List<EntryPaperScore> entryPaperScoreList = paperScoreService.queryPageEntryPaperScoreByGid(gid, page, limit);
        // 分页查询
        int size = paperScoreService.queryCountEntryPaperScoreByGid(gid);
        // 返回数据
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", size);
        map.put("data", entryPaperScoreList);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/updatePaperScore", method = RequestMethod.POST)
    @ResponseBody
    public Object updatePaperScore(@RequestBody InData inData,HttpServletRequest request, HttpSession session){
        Map<String, Object> map = inData.getInmap();
        String sid=(String) map.get("sid");
        Integer paperScore=new Integer(map.get("paperScore").toString());
        PaperScore paperScore1=new PaperScore();
        paperScore1.setSid(sid);
        paperScore1.setPaperScore(paperScore);
        int i= paperScoreService.updatePaperScoreBySid(paperScore1) ;
        if(i>0){
            return JSONObject.toJSON(KitUtil.returnMap("200", StaticFinalVar.UPDATE_OK));
        }else {
            return JSONObject.toJSON(KitUtil.returnMap("101",StaticFinalVar.UPDATE_ERR));
        }
    }

    @RequestMapping(value = "/goLookReplyGroupStudentScore", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goLookReplyGroupStudentScore(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/score/lookReplyGroupStudentScore");
        return mv;
    }

    @RequestMapping(value = "/ReplyGroupStudentScoreGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object ReplyGroupStudentScoreGetAllJson(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        int page = Integer.valueOf(request.getParameter("page"));// 获得页数
        int limit = Integer.valueOf(request.getParameter("limit"));// 获得每页显示条数
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        ReplyGroupTeacher replyGroupTeacher=replyGroupTeacherService.queryReplyGroupTeacherByTid(teacher.getTid());
        int gid=replyGroupTeacher.getGid();
        List<StudentScoreVo> studentScoreVoList = studentScoreService.queryPageStudentScoreVoByGid(gid, page, limit);
        // 分页查询
        int size = studentScoreService.queryCountStudentScoreVoByGid(gid);
        // 返回数据
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", size);
        map.put("data", studentScoreVoList);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/goLookAllStudentScore", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goLookAllStudentScore(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/score/lookAllStudentScore");
        return mv;
    }

    @RequestMapping(value = "/StudentScoreGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object StudentScoreGetAllJson(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        int page = Integer.valueOf(request.getParameter("page"));// 获得页数
        int limit = Integer.valueOf(request.getParameter("limit"));// 获得每页显示条数
        List<StudentScoreVo> studentScoreVoList = studentScoreService.queryPageStudentScoreVo(page, limit);
        // 分页查询
        int size = studentScoreService.queryCountStudentScoreVo();
        // 返回数据
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", size);
        map.put("data", studentScoreVoList);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/goConfirmScore", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goConfirmScore(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/score/finalConfirm");
        return mv;
    }

    @RequestMapping(value = "/finalScoreGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object finalScoreGetAllJson(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        int page = Integer.valueOf(request.getParameter("page"));// 获得页数
        int limit = Integer.valueOf(request.getParameter("limit"));// 获得每页显示条数
        List<ConfirmScore> studentScoreVoList = studentScoreService.queryPageFinalScoreVo(page, limit);
        // 分页查询
        int size = studentScoreService.queryCountFinalScoreVo();
        // 返回数据
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", size);
        map.put("data", studentScoreVoList);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/addStudentScore", method = RequestMethod.POST)
    @ResponseBody
    public Object addStudentScore(HttpServletRequest request, HttpSession session){
        String sid=request.getParameter("sid");
        int id=Integer.valueOf(request.getParameter("id"));
        int adviserScore=Integer.valueOf(request.getParameter("adviserScore"));
        int replyScore=Integer.valueOf(request.getParameter("replyScore"));
        int paperScore=Integer.valueOf(request.getParameter("paperScore"));
        int totalScore=(adviserScore+replyScore+paperScore)/3;
        StudentScore studentScore=new StudentScore();
        studentScore.setSid(sid);
        studentScore.setAdviserScore(adviserScore);
        studentScore.setReplyScore(replyScore);
        studentScore.setPaperScore(paperScore);
        studentScore.setTotalScore(totalScore);
        if(totalScore>=60){
            studentScore.setPassStatus(1);
        }else{
            studentScore.setPassStatus(2);
        }
        int i=  studentScoreService.insertStudentScore(studentScore);
            if(i>0){
            return JSONObject.toJSON(KitUtil.returnMap("200", StaticFinalVar.UPDATE_OK));
        }else {
            return JSONObject.toJSON(KitUtil.returnMap("101",StaticFinalVar.UPDATE_ERR));
        }
    }

}
