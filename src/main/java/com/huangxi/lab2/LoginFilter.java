package com.huangxi.lab2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/Lab2/validation.jsp","/Lab2/welcome.jsp"})
//if filter validate,it will loop redirect to login.jsp
public class LoginFilter implements Filter {
    public void destroy() {
        System.out.println("i am in LoginFilter--destroy()");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("i am in LoginFilter--doFilter()-- request before chain()");
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        if (request.getSession(false)!=null&&request.getSession(false).isNew()) {
            request.getRequestDispatcher("/Lab2/welcome.jsp").forward(request,response);
        } else {
            response.sendRedirect("login.jsp");
            return;//to resolve the error java.lang.IllegalStateException
        }
        chain.doFilter(req, resp);
        System.out.println("i am in LoginFilter--destroy()-- response after chain()");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("i am in LoginFilter--init()");
    }

}