package servlet;

import dao.NormalUserDao;
import dao.NoticeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/DeleteNormalUserServlet"},name = "DeleteNormalUserServlet")
public class DeleteNormalUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        int j=new NormalUserDao().delete(Integer.parseInt(request.getParameter("delete_id")));
        if (j == 0) {
            out.print("<script language='javascript'>alert('���û���ɾ��');window.close();</script>");
            out.close();
        } else {
            out.print("<script language='javascript'>alert('ɾ��ʧ��');window.close();</script>");
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
