package by.fpmibsu.slastymordasty.controller.filters;

import by.fpmibsu.slastymordasty.controller.actions.*;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ActionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req;
        HttpServletResponse resp;

        if(servletRequest instanceof HttpServletRequest){
            req = (HttpServletRequest) servletRequest;
            resp = (HttpServletResponse) servletResponse;
        } else {
            return;
        }

        System.out.println("*");
        String url = req.getRequestURI();
        System.out.println(url);


        if(url.endsWith("jpg")){
            ImageAction imageAction = new ImageAction(req,resp);
            req.setAttribute("action",imageAction);
        } else {
            switch (url){
                case "/Slasty-Mordasty/":
                    StartAction startAction = new StartAction(req,resp);
                    req.setAttribute("action",startAction);
                    break;
                case "/Slasty-Mordasty/reg.jsp":
                    ToRegPageAction toRegPageAction = new ToRegPageAction(req,resp);
                    req.setAttribute("action",toRegPageAction);
                    break;
                case "/Slasty-Mordasty/login.jsp":

                    String email = req.getParameter("email");
                    String password = req.getParameter("password");

                    if(email != null && password != null){
                        LoginAction loginAction = new LoginAction(req,resp);
                        req.setAttribute("action",loginAction);
                    } else{
                        ToLoginPageAction toLoginPageAction = new ToLoginPageAction(req,resp);
                        req.setAttribute("action",toLoginPageAction);
                    }
                    break;

                case "/Slasty-Mordasty/logout.jsp":
                    LogoutAction logoutAction = new LogoutAction(req,resp);
                    req.setAttribute("action",logoutAction);
                    break;

                case "/Slasty-Mordasty/doReg.jsp":
                    break;
            }
        }




        req.getRequestDispatcher("/MainServlet").forward(req,resp);





    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
