package com.huangxi.week6;


import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import java.sql.Connection;
import java.sql.DriverManager;

//tell tomcat this class is a listener:@WebListener
@WebServlet("/jdbc")
@WebListener
public class JDBCServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //like main method for this webapp
        //called when tomcat start
        //we can use this method to get jdbc connection when tomcat start
        ServletContext context = sce.getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");

        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connection --> "+conn);
            //set connection as a context attribute for all jsp and servlet
            context.setAttribute("conn",conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //end point of webapp
        //called when tomcat stop
        //remove connection from context
        sce.getServletContext().removeAttribute("conn");
    }
}