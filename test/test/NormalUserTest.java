package test;

import Util.JDBCUtil;
import dao.NormalUserDao;
import dao.NoticeDao;
import entity.NormalUser;
import entity.Notice;
import org.junit.jupiter.api.Test;

import java.util.List;
/*
 * ������
 * */

public class NormalUserTest {
    @Test
    public void normalUserTest() {
        System.out.println(JDBCUtil.class.getClassLoader().getResource("db.properties").getPath());
        NormalUser normalUser = new NormalUserDao().select("chen");
        System.out.println(normalUser.getDepartment());
        System.out.println(normalUser.getUser_password().equals("chen"));
        System.out.println(normalUser.getUser_name());
        System.out.println(normalUser);
    }

    @Test
    public void noticeTest() {
        List<Notice> notices = new NoticeDao().selectAll("������", "chen");
        System.out.println(notices);
        //System.out.println(new NoticeDao().selectAll("������"));
        //System.out.println(new NoticeDao().insert(new Notice("title","notice","department")));
    }

}

