package com.gdms.filter;

import com.gdms.model.User;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class LoginFilter implements Filter{
    private String excludedPage;
    private String[] excludedPages;

    public void init(FilterConfig filterConfig) throws ServletException {
        excludedPage = filterConfig.getInitParameter("excludedPages");
        if (excludedPage != null && excludedPage.length() > 0){
            excludedPages = excludedPage.split(",");
        }
    }


    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp =(HttpServletResponse)servletResponse;
        HttpSession session = req.getSession();
        // 获得用户请求的URI
        String path = req.getRequestURI();
        // 从session取得已经登录验证的凭证 我这里的demo用的是password来作为登录凭证
        User user= (User) session.getAttribute("user");
        // login.jsp页面无需过滤(根据自己项目的要求来)
        // 定义表示变量 并验证用户请求URL 是否包含不过滤路径
        boolean flag = false;
        for (String page:excludedPages) {
            if (path.contains(page)){
                flag = true;
            }
        }
        // 也可以path.contains("login.jsp")  反正怎么精确怎么来就不多说了
//        System.out.println("path:"+path);
        if (flag){
            filterChain.doFilter(req,resp);
        }else{//如果不是login.jsp进行过滤
            if ( user== null) {
                // 跳转到登陆页面
                System.out.println("拦截了未登录的请求");
                req.getRequestDispatcher("/templates/view/login.jsp").forward(req,resp);
            } else {
                // 已经登陆,继续此次请求
                filterChain.doFilter(req, resp);
            }
        }
    }


    public void destroy() {

    }
}