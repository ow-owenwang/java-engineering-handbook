package org.example.upload.upload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.example.upload.util.CommonUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

/*
 * ServletFileUpload 在接收上传文件数据时，会将内容保存到内存缓存区中，如果文件内容超过了 DiskFileItemFactory 指定的缓冲区的大小，那么文件将被保存到磁盘上，存储为 DiskFileItemFactory 指定目录中的临时文件。
 * 等文件数据都接收完毕后，ServletUpload 再从文件中将数据写入到上传文件目录下的文件中。
 * */
@WebServlet(name = "upload3Servlet", value = "/upload3Servlet")
public class Upload3Servlet extends HttpServlet {

    //上传目录
    private static final String UPLOAD_DIR = "uploads";

    /*
     * 上传配置
     * */
    //3MB
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;
    //40MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40;
    //50MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DiskFileItemFactory factory = new DiskFileItemFactory();
        //创建对象时指定缓存大小和缓存目录
        //DiskFileItemFactory factory = new DiskFileItemFactory(20 * 1024, new File("f:/temp"));

        //设置缓存临界值，超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        //设置缓存目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload sfu = new ServletFileUpload(factory);

        /*
         * 以下两个设置必须在 parseRequest() 前
         * */
        //设置单个上传文件最大值
        sfu.setFileSizeMax(MAX_FILE_SIZE);
        //设置整个表单最大值
        sfu.setSizeMax(MAX_REQUEST_SIZE);
        //设置编码
        sfu.setHeaderEncoding("utf-8");

        try {
            List<FileItem> fileItems = sfu.parseRequest(request);

            if (fileItems != null && fileItems.size() > 0) {
                for (FileItem item : fileItems) {
                    if (!item.isFormField()) {
                        String name = item.getName();

                        //处理文件名的绝对路径问题
                        int i = name.lastIndexOf("\\");
                        if (i != -1) {
                            name = name.substring(i + 1);
                        }

                        //给文件名添加 uuid 前缀，处理文件同名问题
                        String saveName = CommonUtils.uuid() + "_" + name;
                        //得到 hashCode
                        int hCode = name.hashCode();
                        String hex = Integer.toHexString(hCode);
                        //获取 hex 的前两个字母，与 uploadPath 连接在一起，生成一个完整的路径
                        File file = new File(getServletContext().getRealPath("/WEB-INF/" + UPLOAD_DIR), hex.charAt(0) + "/" + hex.charAt(1));
                        if (!file.exists()) {
                            boolean b = file.mkdirs();
                            System.out.println(b);
                        }

                        item.write(new File(file, saveName));

                    }else{
                        //普通字段直接打印
                        String fieldName = item.getFieldName();
                        String value = item.getString();
                        System.out.println(fieldName + ": " + value);
                    }
                }
            }

        } catch (FileUploadBase.FileSizeLimitExceededException e) {
            request.setAttribute("msg", "单个文件超出最大值！");
            request.getRequestDispatcher("/upload3.jsp").forward(request, response);
        } catch (FileUploadBase.SizeLimitExceededException e) {
            request.setAttribute("msg", "您上传的文件超出了" + MAX_FILE_SIZE);
            request.getRequestDispatcher("/upload3.jsp").forward(request, response);
        } catch (FileUploadException e) {
            request.setAttribute("msg", "上传文件失败！");
            request.getRequestDispatcher("/upload3.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
