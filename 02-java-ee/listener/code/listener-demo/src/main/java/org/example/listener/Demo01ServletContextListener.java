package org.example.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 */
@WebListener
public class Demo01ServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext 创建了");

        //加载资源文件
        ServletContext context = sce.getServletContext();
        String location = context.getInitParameter("configFileLocation");
        String path = context.getRealPath(location);
        try {
            FileInputStream fis = new FileInputStream(path);
            System.out.println(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext 销毁了");
    }
}
