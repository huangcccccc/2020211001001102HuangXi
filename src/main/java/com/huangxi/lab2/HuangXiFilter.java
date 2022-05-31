package com.huangxi.lab2;

import javax.servlet.*;
import java.io.IOException;

public class HuangXiFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("HuangXiFilter-->before chain");
        chain.doFilter(req, resp);
        System.out.println("HuangXiFilter-->after chain");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}