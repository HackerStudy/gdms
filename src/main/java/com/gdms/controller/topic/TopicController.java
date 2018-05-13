package com.gdms.controller.topic;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@Scope("prototype")
@RequestMapping("/topic")
public class TopicController {
    private Logger log = Logger.getLogger(TopicController.class);

    @RequestMapping(value = "/goApplyByOneself", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goApplyByOneself(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/topic/applyTopicByOneself");
        return mv;
    }

    @RequestMapping(value = "/goApplyByOther", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goApplyByOther(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("view/topic/applyTopicByOther");
        return mv;
    }

    @RequestMapping(value = "/goLookApplyResult", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goLookApplyResult(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("view/topic/lookApplyResult");
        return mv;
    }
}
