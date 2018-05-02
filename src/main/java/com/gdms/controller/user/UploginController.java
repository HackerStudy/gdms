package com.gdms.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UploginController {
    /**
     * 后台用户退出方法
     * @param session
     * @return
     */
    @RequestMapping(value = "/uplogin", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView uplogin(HttpSession session){
        // 新建返回值对象
        ModelAndView mv = new ModelAndView();
        // 新建返回值对象
        session.removeAttribute("user");
        session.removeAttribute("limitList");
        mv.setViewName("/view/login");
        return mv;
    }
}
