package org.example.upload.upload;

import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "upload1Servlet", value = "/upload1Servlet")
public class Upload1Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //获取请求的输入流
        ServletInputStream in = request.getInputStream();
        String s = IOUtils.toString(in, StandardCharsets.UTF_8);
        System.out.println(s);
    }
}
