package servlet;

import dao.DepartmentDao;
import dao.NormalUserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/DeleteDepartmentServlet"},name = "DeleteDepartmentServlet")
public class DeleteDepartmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        int j=new DepartmentDao().delete(Integer.parseInt(request.getParameter("delete_id")));
        if (j == 0) {
            out.print("<script language='javascript'>alert('ɾ�����ųɹ�');window.opener.location.reload();window.close();</script>");
            out.close();
        } else {
            out.print("<script language='javascript'>alert('ɾ��ʧ��');window.opener.location.reload();window.close();</script>");
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
