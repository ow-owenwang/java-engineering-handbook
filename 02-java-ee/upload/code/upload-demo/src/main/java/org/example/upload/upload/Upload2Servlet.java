package org.example.upload.upload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "upload2Servlet", value = "/upload2Servlet")
public class Upload2Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(factory);

        //进度
        sfu.setProgressListener((pBytesRead, pContentLength, arg2) -> System.out.println("文件大小为：" + pContentLength + "，当前已处理：" + pBytesRead));

        //判断 enctype 是否为 multipart/form-data
        System.out.println(ServletFileUpload.isMultipartContent(request));

        try {
            List<FileItem> fileItems = sfu.parseRequest(request);
            FileItem f1 = fileItems.get(0);
            FileItem f2 = fileItems.get(1);

            System.out.println(f1.getFieldName() + ": " + f1.getString());

            System.out.println("Content-Type: " + f2.getContentType());
            System.out.println("size: " + f2.getSize());
            System.out.println("filename: " + f2.getName());

            //==========================
            for (FileItem item : fileItems) {
                String fieldName = item.getFieldName();
                if ("hobby".equals(fieldName)) {
                    System.out.println(fieldName + ": " + item.getString());
                }
            }
            //==========================


            File destFile = new File("d:/upload.jpg");
            f2.write(destFile);
        } catch (FileUploadException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
