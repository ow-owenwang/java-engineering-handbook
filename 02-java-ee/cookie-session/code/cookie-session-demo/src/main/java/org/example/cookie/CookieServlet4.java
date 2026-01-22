package org.example.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 小案例：
 *
 * 在服务器中的 Servlet 判断是否有一个名为 lastTime 的 Cookie。
 * 有：不是第一次访问
 *     1. 响应数据：欢迎回来，您上次访问时间为：2018年6月10日11:50:20
 *     2. 写回 Cookie：lastTime=2018年6月10日11:50:01
 * 没有：是第一次访问
 *     1. 响应数据：您好，欢迎您首次访问
 *     2. 写回 Cookie：lastTime=2018年6月10日11:50:01
 */
@WebServlet(name = "CookieServlet4", value = "/CookieServlet4")
public class CookieServlet4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的消息体的数据格式以及编码
        response.setContentType("text/html;charset=utf-8");

        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        if(cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if("lastTime".equals(name)){
                    flag = true;
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(new Date());
                    System.out.println("编码前："+str_date);
                    //URL 编码
                    str_date = URLEncoder.encode(str_date,"utf-8");
                    System.out.println("编码后："+str_date);
                    cookie.setValue(str_date);
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    response.addCookie(cookie);

                    String value = cookie.getValue();
                    System.out.println("解码前："+value);
                    //URL解码：
                    value = URLDecoder.decode(value,"utf-8");
                    System.out.println("解码后："+value);
                    response.getWriter().write("<h1>欢迎回来，您上次访问时间为:"+value+"</h1>");


                    break;

                }
            }
        }


        if(cookies == null || cookies.length == 0 || flag == false){
            Date date  = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);
            System.out.println("编码前："+str_date);
            //URL编码
            str_date = URLEncoder.encode(str_date,"utf-8");
            System.out.println("编码后："+str_date);

            Cookie cookie = new Cookie("lastTime",str_date);
            //设置cookie的存活时间
            cookie.setMaxAge(60 * 60 * 24 * 30);//一个月
            response.addCookie(cookie);

            response.getWriter().write("<h1>您好，欢迎您首次访问</h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
