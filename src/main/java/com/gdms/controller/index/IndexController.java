package com.gdms.controller.index;

import com.gdms.controller.user.AdminController;
import com.gdms.service.admin.AdminService;
import com.gdms.service.g.GGroupLimitService;
import com.gdms.service.g.GGroupService;
import com.gdms.service.web.WebSettingService;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@Scope("prototype")
@RequestMapping("/school")
public class IndexController {
    private Logger log = Logger.getLogger(AdminController.class);

    @Resource
    private AdminService adminService;
    @Resource
    private WebSettingService webSettingService;
    @Resource
    private GGroupLimitService gGroupLimitService;
    @Resource
    private GGroupService gGroupService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView index(HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/schoolindex");
        return mv;
    }
}
