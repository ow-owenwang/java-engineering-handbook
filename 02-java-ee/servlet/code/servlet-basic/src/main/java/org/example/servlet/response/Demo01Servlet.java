package org.example.servlet.response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "Demo01Servlet", value = "/Demo01Servlet")
public class Demo01Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuffer sb = new StringBuffer();
        sb.append("\r\n");
        sb.append("<!DOCTYPE html><html><head>\r\n");
        sb.append("  <meta charset=\"gbk\">\r\n");//gbk
        sb.append("  <title></title>\r\n");
        sb.append("</head><body>\r\n");
        sb.append("\t没有什么是一拳解决不了的，如果有，那就两拳。\r\n");
        sb.append("</body></html>");
        String html = sb.toString();

        // 此处的编码是gbk和utf-8都能正常显示，怎么回事？
        response.setContentType("text/html;charset=gbk");

        // BOM头
        response.getOutputStream().write(0xEF);
        response.getOutputStream().write(0xBB);
        response.getOutputStream().write(0xBF);
        response.getOutputStream().write(html.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
