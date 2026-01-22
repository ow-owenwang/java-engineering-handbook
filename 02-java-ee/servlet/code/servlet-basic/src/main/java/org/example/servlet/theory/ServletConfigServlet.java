package org.example.servlet.theory;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class ServletConfigServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //获取 Servlet 上下文
        ServletContext servletContext = servletConfig.getServletContext();
        System.out.println(servletContext);//org.apache.catalina.core.ApplicationContextFacade@128a64df
        //获取 Servlet 名称
        String servletName = servletConfig.getServletName();
        System.out.println(servletName);//servletConfig
        //获取初始化参数 p1
        String p1 = servletConfig.getInitParameter("p1");
        System.out.println(p1);//value1
        //获取初始化参数
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String s = initParameterNames.nextElement();
            System.out.println(s);
        }

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service()...");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
