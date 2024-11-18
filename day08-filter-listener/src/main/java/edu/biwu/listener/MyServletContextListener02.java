package edu.biwu.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener02 implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("ServletContextListener02被创建");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("ServletContextListener02被删除");
    }
}
