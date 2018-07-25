package servlet;

import dao.AdminUserDao;
import dao.AdministratorDao;
import dao.NormalUserDao;
import dao.NoticeDao;
import entity.AdminUser;
import entity.Administrator;
import entity.NormalUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/*
* �û���¼servlet
* */
@WebServlet(urlPatterns = {"/LogInServlet"},name = "LogInServlet")
public class LogInServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        //��ȡ�û�ѡ������ĸ����͵��û�
        String radio =request.getParameter("user");
        //��ȡ�û���
        String user_name=request.getParameter("user_name");
        //�ж��Ƿ�Ϊ��ͨ�û�
        if (radio.equals("��ͨ�û�")) {
            System.out.println("��ͨ�û�");
            //��ѯ���û���Ϣ
            NormalUser normalUser=new NormalUserDao().select(user_name);
            //�ж��˺��Ƿ����
            if (normalUser != null) {
                //�ж��˺������Ƕ���ȷ
                if (user_name.equals(normalUser.getUser_name())
                        && request.getParameter("user_password").equals(normalUser.getUser_password())) {
                    //response.sendRedirect("/normalUser.jsp");
                    /*HttpSession session = request.getSession();
                    session.setAttribute("name",request.getParameter("user_name"));*/
                   // request.getSession().setAttribute("user_name ",user_name);
                    try {
                        //���û���Ϣ���ݵ��û�����
                        request.setAttribute("user_name",normalUser);
                        System.out.println(request.getAttribute("user_name"));
                        //��������Ϣ����ȥ
                        request.setAttribute("department",new NoticeDao().selectAll(normalUser.getDepartment()));
                        request.getRequestDispatcher("/normalUser.jsp").forward(request,response);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    }
                } else {
                    out.print("<script language='javascript'>alert('�˺Ż����������');window.location.href='index.jsp';</script>");
                    out.close();
                }
            } else {
                out.print("<script language='javascript'>alert('�˺Ų�����');window.location.href='index.jsp';</script>");
                out.close();
            }
        } else if (radio.equals("���Ĺ����û�")) {
            //��ѯ���û���Ϣ
            AdminUser adminUser = new AdminUserDao().select(user_name);
            //�ж��˺��Ƿ����
            if (adminUser != null) {
                if (user_name.equals(adminUser.getUser_name())
                        && request.getParameter("user_password").equals(adminUser.getUser_password())) {
                    try {
                        //���û���Ϣ���ݵ��û�����
                        request.setAttribute("adminUser", adminUser);
                        request.setAttribute("department",new NoticeDao().selectAll(adminUser.getDepartment()));
                        request.getRequestDispatcher("/adminUser.jsp").forward(request, response);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    }
                } else {
                    out.print("<script language='javascript'>alert('�˺Ż����������');window.location.href='index.jsp';</script>");
                    out.close();
                }
            } else {
                out.print("<script language='javascript'>alert('�˺Ų�����');window.location.href='index.jsp';</script>");
                out.close();
            }

        } else {
            //��ѯ���û���Ϣ
            Administrator administrator = new AdministratorDao().select(user_name);
            //�ж��˺��Ƿ����
            if (administrator != null) {
                if (user_name.equals(administrator.getUser_name())
                        && request.getParameter("user_password").equals(administrator.getUser_password())) {
                    try {
                        //���û���Ϣ���ݵ��û�����
                        request.setAttribute("administrator", administrator);
                        request.getRequestDispatcher("/administrator.jsp").forward(request, response);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    }
                } else {
                    out.print("<script language='javascript'>alert('�˺Ż����������');window.location.href='index.jsp';</script>");
                    out.close();
                }
            } else {
                out.print("<script language='javascript'>alert('�˺Ų�����');window.location.href='index.jsp';</script>");
                out.close();
            }
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}