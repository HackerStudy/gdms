package com.gdms.controller.user;

import cc.openkit.common.KitUtil;
import com.alibaba.fastjson.JSONObject;
import com.gdms.model.Admin;
import com.gdms.model.GGroup;
import com.gdms.model.WebSetting;
import com.gdms.service.admin.AdminService;
import com.gdms.service.g.GGroupLimitService;
import com.gdms.service.g.GGroupService;
import com.gdms.service.web.WebSettingService;
import com.gdms.util.StaticFinalVar;
import com.gdms.vo.LimitVo;
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
import java.util.List;

/**
 * 后台管理员类的方法
 *
 * @author bigben
 * @date 2018.2.5
 */
@Controller
@Scope("prototype")
@RequestMapping("/admin")
public class AdminController {
    private Logger log = Logger.getLogger(AdminController.class);

    @Resource
    private AdminService adminService;
    @Resource
    private WebSettingService webSettingService;
    @Resource
    private GGroupLimitService gGroupLimitService;
    @Resource
    private GGroupService gGroupService;


    /**
     * 用户后台登录页面跳转
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView index(HttpSession session){
        log.info("用户登录跳转方法");
        log.debug("测试debug");
        WebSetting webSetting = webSettingService.queryById(1);
        System.out.println(webSetting.toString());
        // 新建返回值对象
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/view/login");
        session.setAttribute("kitWeb",webSetting);
        return mv;
    }

    /**
     * 登录验证方法
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(value = "/tologin", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView tologin(HttpServletRequest request, HttpSession session){
        log.info("开始登陆了");
        // 新建返回值对象
        ModelAndView mv = new ModelAndView();
        // 取值
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int identity=Integer.valueOf(request.getParameter("identityid"));
        // 组装对象
        Admin admin = new Admin();
        admin.setKitAdminUsername(username);
        admin.setKitAdminPassword(password);
        Admin returnAdmin = adminService.getModelByUsernameAndPassword(admin);
//        System.out.println(returnAdmin.toString());
        // 查询
//        Admin returnAdmin = adminService.getModelByUsernameAndPassword(admin);
        if(returnAdmin==null){
            // 如果为空，跳转到登录页面
            mv.setViewName("/view/login");
            mv.addObject("msg", StaticFinalVar.USERNAME_OR_PWD_ERR);
            return mv;
        }

        // 得到他的权限
        List<LimitVo> limitVoList = gGroupLimitService.getModelByGroupId(returnAdmin.getGroupId());
        log.info("他的权限有 "+limitVoList.size()+" 个！");
        System.out.println("该用户的权限有:"+limitVoList.size());
        // 获取他的功能模块
        mv.setViewName("/view/index");
        session.setAttribute("admin",returnAdmin);
        session.setAttribute("limitList",limitVoList);
        return mv;
    }

    /**
     * 后台用户退出方法
     * @param session
     * @return
     */
    @RequestMapping(value = "/uplogin", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView uplogin(HttpSession session){
        log.info("后台退出");
        // 新建返回值对象
        ModelAndView mv = new ModelAndView();
        WebSetting webSetting = webSettingService.queryById(1);
        // 新建返回值对象
        session.setAttribute("kitWeb",webSetting);
        session.removeAttribute("admin");
        session.removeAttribute("limitList");
        mv.setViewName("/view/login");
        return mv;
    }

    /**
     * 获取所有管理员用户
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ModelAndView getAll(HttpSession session){
        ModelAndView mv=new ModelAndView();
        List<Admin> adminList=adminService.getAlladmin();
        // 取值
        mv.setViewName("/view/admin/list");
        mv.addObject("adminlist",adminList);
        return mv;
    }

//    /**
//     * 当跳转到列表页面开始渲染数据
//     *
//     * @param request
//     * @return
//     */
//    @RequestMapping(value = "/getAllJson", method = RequestMethod.POST)
//    @ResponseBody
//    public Object getAllJson(HttpServletRequest request){
//        log.info("查看所有的管理员，返回 json");
//
//        Map<String,Object> map = new HashMap<String,Object>();
//
//        String page = request.getParameter("page");// 获得页数
//        String limit = request.getParameter("limit");// 获得每页显示条数
//        String search = request.getParameter("search");// 获取搜索条件
//
////        封装数据
//        Admin user = new Admin();
//        if(KitUtil.feikong(search)){
//            user.setKitAdminName(search);
//        }
//
//        // 分页查询
//        List<Admin> adminList = adminService.queryPageListByWhere(user, Integer.valueOf(page), Integer.valueOf(limit));
//        int size = adminService.queryCount(user);
//
//        List<GGroup> gGroupList = gGroupService.queryAll();
//        // 封装返回数据
//        List<AdminVo> adminVoList = new ArrayList<AdminVo>();
//        for(int i=0; i<adminList.size(); i++){
//            AdminVo adminVo = new AdminVo(adminList.get(i));
//            for(int j=0; j<gGroupList.size(); j++){
//                if(adminList.get(i).getGroupId().equals(gGroupList.get(j).getGroupId())){
//                    adminVo.setGroupName(gGroupList.get(j).getGroupName());
//                }
//            }
//            adminVoList.add(adminVo);
//        }
//
//        System.out.println("抓到的数据总数："+adminVoList.size());
//
//        // 返回数据
//        map.put("code",0);
//        map.put("msg","");
//        map.put("count",size);
//        map.put("data",adminVoList);
//
//        return JSONObject.toJSON(map);
//    }

    /**
     * 去添加页面
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/goAdd", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goAdd(HttpServletRequest request){
        log.info("用户 》 添加 》 跳转");
        ModelAndView mv = new ModelAndView();
        List<GGroup> groups = gGroupService.queryAll();
        mv.setViewName("/view/group/add");
        mv.addObject("kitList",groups);
        return mv;
    }

    /**
     * 添加
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Object add(HttpServletRequest request){
        log.info("用户 》 添加 》 保存");
        String kitAdminName = request.getParameter("kitAdminName");
        String imgurl = request.getParameter("imgurl");
        String kitAdminUsername = request.getParameter("kitAdminUsername");
        String kitAdminPassword = request.getParameter("kitAdminPassword");
//        String kitAdminPasswordAgen = request.getParameter("kitAdminPasswordAgen");
        String groupId = request.getParameter("groupId");
//        if(!kitAdminPassword.equals(kitAdminPasswordAgen)){
//            return KitUtil.returnMap("200",StaticFinalVar.PWD_NOT_EQUERY);
//        }
        Admin admin = new Admin();
        admin.setKitAdminId(KitUtil.uuid());
        admin.setKitAdminName(kitAdminName);
        admin.setKitAdminUsername(kitAdminUsername);
        admin.setKitAdminImgUrl(imgurl);
        admin.setKitAdminPassword(kitAdminPassword);
        admin.setGroupId(Integer.valueOf(groupId));
        System.out.println("admin:"+admin.toString());
        Boolean b=adminService.insertAdmin(admin);
        if(b){
            return JSONObject.toJSON(KitUtil.returnMap("200",StaticFinalVar.ADD_OK));
        }else {
            return JSONObject.toJSON(KitUtil.returnMap("101",StaticFinalVar.ADD_ERR));
        }
    }

    /**
     * 删除
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ResponseBody
    public Object del(HttpServletRequest request){
        log.info("用户 》 删除");
        String id = request.getParameter("id");
        // 获取session
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        // 如果被删除的 是当前登录的用户
        if(admin.getGroupId().equals(id)){
            return KitUtil.returnMap("101",StaticFinalVar.DEL_ADMIN_BUT_IS_LOGIN);
        }

        int i = adminService.deleteByUUId(id);
        return i==1?KitUtil.returnMap("200",StaticFinalVar.DEL_OK):KitUtil.returnMap("101",StaticFinalVar.DEL_ERR);

    }

    /**
     * 去修改页面
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/goUpdate", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView goUpdate(HttpServletRequest request){
        log.info("用户 》 修改 》 跳转");
        ModelAndView mv = new ModelAndView();
        String kitAdminId = request.getParameter("kitAdminId");
        Admin admin = adminService.selectAdminById(kitAdminId);
        mv.setViewName("/view/admin/update");
        mv.addObject("updateAdmin",admin);
        return mv;
    }

    /**
     * 修改
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Object update(HttpServletRequest request){
        log.info("用户 》 修改 》 保存");
        String kitAdminId = request.getParameter("kitAdminId");
        String kitAdminName = request.getParameter("kitAdminName");
        String kitAdminUsername = request.getParameter("kitAdminUsername");
        String groupId = request.getParameter("groupId");
//        String data = request.getParameter("data");
//        JSONObject jsonObj = JSONObject.parseObject(data);
//        String id=jsonObj.getString("kitAdminId");
        System.out.println("username:"+kitAdminUsername);
        System.out.println("name:"+kitAdminName);
        Admin user = new Admin();
//        String kitAdminId=adminService.findAdminIdByAdminUsername(kitAdminUsername);
        user.setKitAdminId(kitAdminId);
        user.setKitAdminName(kitAdminName);
        user.setKitAdminUsername(kitAdminUsername);
//        user.setKitAdminImgUrl(jsonObj.getString("imgurl"));
        user.setGroupId(Integer.valueOf(groupId));
//          int i=1;
        int i = adminService.updateByAdminId(user);
//        int i = adminService.save(user);
//        System.out.println(i);

        return JSONObject.toJSON(i==1 ? KitUtil.returnMap("200",StaticFinalVar.UPDATE_OK) : KitUtil.returnMap("101",StaticFinalVar.UPDATE_ERR));
    }
}
