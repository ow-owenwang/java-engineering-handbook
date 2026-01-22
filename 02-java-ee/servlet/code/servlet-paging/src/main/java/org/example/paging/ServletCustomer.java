package org.example.paging;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletCustomer", value = "/ServletCustomer")
public class ServletCustomer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public String findAll(HttpServletRequest request, HttpServletResponse response) {
        int pc = getPc(request);
        int ps = 10;
        PageBean<Customer> pb = customerService.findAll(pc, ps);
        request.setAttribute("pb", pb);
        return "forward:/list.jsp";
    }

    /**
     * 获取页码，不存在返回1
     *
     * @param request
     * @return
     */
    public int getPc(HttpServletRequest request) {
        String pc = request.getParameter("pc");
        if (pc == null || pc.trim().isEmpty()) {
            return 1;
        }
        return Integer.parseInt(pc);
    }

}
