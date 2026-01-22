package org.example.servlet;



import org.example.servlet.utils.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet(name = "VerifyCodeServlet", urlPatterns = {"/VerifyCode"})
public class VerifyCodeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 生成图片
         * 保存图片上验证码文本到session域中
         * 将图片响应给客户端
         */
        VerifyCode vc = new VerifyCode();
        BufferedImage image = vc.getImage();
        request.getSession().setAttribute("vcode", vc.getText());

        VerifyCode.output(image, response.getOutputStream());
    }
}
