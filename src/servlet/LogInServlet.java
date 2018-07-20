package servlet;

import dao.NormalUserDao;
import entity.NormalUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/LogInServlet"},name = "LogInServlet")
public class LogInServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String radio =request.getParameter("user");
        String user_name=request.getParameter("user_name");

        //�ж��Ƿ�Ϊ��ͨ�û�
        if (radio.equals("��ͨ�û�")) {
            System.out.println("��ͨ�û�");
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
                        request.setAttribute("user_name",normalUser);
                        System.out.println(request.getAttribute("user_name"));
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
            System.out.println("���Ĺ����û�");
            out.print("<script language='javascript'>alert('�˺Ż����������');window.location.href='index.jsp';</script>");
            out.close();
        } else {
            System.out.println("����Ա");
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}