package org.example.servlet.theory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

/**
 * 获取当前 WEB 应用的某一个文件在服务器上的绝对路径, 而不是部署前的路径
 */
@WebServlet(name = "ServletContextServlet1", value = "/ServletContextServlet1")
public class ServletContextServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String realPath = getServletContext().getRealPath("/index.jsp");
        System.out.println(realPath);//C:\Users\fzw-wangzy\Desktop\1\javaweb_code\servlet_demo\target\servlet_demo\index.jsp

        InputStream is = getServletContext().getResourceAsStream("/index.jsp");
        System.out.println(is);//java.io.ByteArrayInputStream@740703d7

        //获取 WEB-INF 目录下所有资源的路径
        Set<String> paths = getServletContext().getResourcePaths("/WEB-INF");
        System.out.println(paths);//[/WEB-INF/lib/, /WEB-INF/classes/, /WEB-INF/web.xml]
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
