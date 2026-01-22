package org.example.download.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "download1Servlet", value = "/download1Servlet")
public class Download1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");
        String filePath = getServletContext().getRealPath("/img/" + filename);
        //对中文名进行处理，或者通过 URLEncoder.encode()
        String filename1 = new String(filename.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        System.out.println(filename1);//乱码

        //获取文件 MIME 类型
        String mime = getServletContext().getMimeType(filename);

        response.setHeader("Content-Type", mime);
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "utf-8"));

        FileInputStream input = new FileInputStream(filePath);
        ServletOutputStream output = response.getOutputStream();

        byte[] buf = new byte[1024 * 8];
        int len = 0;
        while ((len = input.read(buf)) != -1) {
            output.write(buf, 0, len);
        }

        //利用 commons-io
        //IOUtils.copy(input, output);

        input.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
