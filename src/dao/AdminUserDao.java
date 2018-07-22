package dao;

import Util.JDBCUtil;
import entity.AdminUser;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/*
* ���Ĺ����û����ݿ������
* */
public class AdminUserDao {
    //�����û����鿴�û���Ϣ
    public AdminUser select(String user_name) {
        try {
            String selectSQL = "select * from AdminUser where user_name=?";
            return JDBCUtil.queryRunner().query(selectSQL, new BeanHandler<AdminUser>(AdminUser.class), user_name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //����û�
    public int insert(AdminUser adminUser) {
        try {
            String insertSQL = "INSERT INTO AdminUser(user_name,user_password,department) values(?,?,?)";
            JDBCUtil.queryRunner().update(insertSQL, adminUser.getUser_name(), adminUser.getUser_password(), adminUser.getDepartment());
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }

    }


    //�����û�id�鿴�û���Ϣ
    public AdminUser select(int user_id) {
        try {
            String selectSQL = "select * from AdminUser where AdminUser_id=?";
            return JDBCUtil.queryRunner().query(selectSQL, new BeanHandler<AdminUser>(AdminUser.class), user_id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //�鿴�����û�
    public List<AdminUser> selectAll() {
        try {
            String selectSQL = "select * from AdminUser";
            return JDBCUtil.queryRunner().query(selectSQL, new BeanListHandler<AdminUser>(AdminUser.class));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //����idɾ���û�
    public int delete(int i) {
        String deleteSQL = "delete from AdminUser where AdminUser_id=?";
        try {
            JDBCUtil.queryRunner().update(deleteSQL, i);
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
    }

    //����id�����û���Ϣ
    public int update(AdminUser adminUser, int user_id) {
        String updateSQL = "UPDATE AdminUser SET user_name=?,user_password=?,department=? where AdminUser_id=?";
        try {
            JDBCUtil.queryRunner().update(updateSQL, adminUser.getUser_name(), adminUser.getUser_password(), adminUser.getDepartment(), user_id);
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
    }
}
