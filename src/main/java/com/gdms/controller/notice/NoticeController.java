package com.gdms.controller.notice;

import cc.openkit.common.KitUtil;
import com.alibaba.fastjson.JSONObject;
import com.gdms.controller.user.UserController;
import com.gdms.model.Department;
import com.gdms.model.Major;
import com.gdms.model.Notice;
import com.gdms.model.Student;
import com.gdms.service.notice.NoticeService;
import com.gdms.service.user.UserService;
import com.gdms.util.StaticFinalVar;
import com.gdms.util.StringAndDate;
import com.gdms.vo.NoticeVo;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@Scope("prototype")
@RequestMapping("/notice")
public class NoticeController {
    private Logger log = Logger.getLogger(UserController.class);

    @Resource
    private NoticeService noticeService;

    @RequestMapping(value = "/goReleaseNotice", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView releaseNoticeInfo(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/notice/releaseNotice");
        return mv;
    }

    @RequestMapping(value = "/addNotice", method = RequestMethod.POST)
    @ResponseBody
    public Object insertNoticeInfo(HttpServletRequest request){

        Map<String, Object> map = new HashMap<String, Object>();
        log.info("分组 》 添加 》 保存");
        // 获取分组名字
        String title = request.getParameter("title");
        String theTime = request.getParameter("theTime");
        Date time= StringAndDate.stringToDate(theTime);
        String url=request.getParameter("url");
        // 先保存组
        Notice notice=new Notice();
         notice.setTitle(title);
         notice.setTime(time);
         notice.setUrl(url);
        // 如果没有重复，先添加，然后查询这条数据
        int i = noticeService.insertNotice(notice);
        if(i!=1){
            map = KitUtil.returnMap("101", StaticFinalVar.ADD_ERR);
            return JSONObject.toJSON(map);
        }
        map = KitUtil.returnMap("200",StaticFinalVar.ADD_OK);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/goNotice", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView AllNoticeInfo(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/notice/notice");
        return mv;
    }

    @RequestMapping(value = "/noticeGetAllJson", method = RequestMethod.POST)
    @ResponseBody
    public Object NoticeGetAllJson(HttpServletRequest request){
        log.info("查看所有的分组，返回 json");
        Map<String,Object> map = new HashMap<String,Object>();
        String page = request.getParameter("page");// 获得页数
        String limit = request.getParameter("limit");// 获得每页显示条数
        Notice notice=new Notice();
        List<Notice> noticeList =  noticeService.queryPageListByWhere(notice, Integer.valueOf(page), Integer.valueOf(limit));
        // 分页查询
        List<NoticeVo> noticeVoList=new ArrayList<NoticeVo>();
        for (Notice list:noticeList) {
            String time=StringAndDate.dateToString(list.getTime());
            NoticeVo noticeVo=new NoticeVo(list.getId(),list.getTitle(),time,list.getUrl());
            noticeVoList.add(noticeVo);
        }
        int size = noticeService.queryCount(notice);
        // 返回数据
        map.put("code",0);
        map.put("msg","");
        map.put("count",size);
        map.put("data",noticeVoList);
        return JSONObject.toJSON(map);
    }

    @RequestMapping(value = "/goUpdateNotice", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goUpdateNotice(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        Integer id = Integer.valueOf(request.getParameter("id"));
        Notice notice=noticeService.queryById(id);
        NoticeVo noticeVo=new NoticeVo(notice.getId(),notice.getTitle(),StringAndDate.dateToString(notice.getTime()),notice.getUrl());
        mv.addObject("noticeVo",noticeVo);
        mv.setViewName("/view/notice/editNoticeInfo");
        return mv;
    }

    @RequestMapping(value = "/updateNotice", method = RequestMethod.POST)
    @ResponseBody
    public Object updateNotice(HttpServletRequest request){
        log.info("用户 》 修改 》 保存");
        Integer id = Integer.valueOf(request.getParameter("id"));
        String title = request.getParameter("title");
        String time = request.getParameter("theTime");
        String url = request.getParameter("url");
        Notice notice=new Notice();
        notice.setId(id);
        notice.setTitle(title);
        notice.setTime(StringAndDate.stringToDate(time));
        notice.setUrl(url);
        int i=noticeService.updateNotice(notice);
        return JSONObject.toJSON(i==1 ? KitUtil.returnMap("200",StaticFinalVar.UPDATE_OK) : KitUtil.returnMap("101",StaticFinalVar.UPDATE_ERR));
    }

    @RequestMapping(value = "/delNotice", method = RequestMethod.POST)
    @ResponseBody
    public Object del(HttpServletRequest request){
        Map<String, Object> map = new HashMap<String, Object>();
        Integer id = Integer.valueOf(request.getParameter("id"));
        // 删除
        int i = noticeService.deleteById(id);
        map = (i>0)? KitUtil.returnMap("200", StaticFinalVar.DEL_OK):KitUtil.returnMap("101",StaticFinalVar.DEL_ERR);
        return JSONObject.toJSON(map);
    }

}
