package com.gdms.controller.user;

import com.gdms.model.User;
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
        User user=(User) session.getAttribute("user");
        // 新建返回值对象
        if(user.getIdentity()==1||user.getIdentity()==5){
            session.removeAttribute("admin");
        }else if(user.getIdentity()==2){
            session.removeAttribute("student");
        }else{
            session.removeAttribute("teacher");
        }
        session.removeAttribute("user");
        session.removeAttribute("limitList");
        mv.setViewName("/view/login");
        return mv;
    }
}
