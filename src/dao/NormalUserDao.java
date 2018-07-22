package dao;

import Util.JDBCUtil;
import entity.NormalUser;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/*
 * ��ͨ�û����ݿ������
 * */
public class NormalUserDao {
    //�����û����鿴�û���Ϣ
    public NormalUser select(String user_name) {
        try {
            String selectSQL = "select * from NormalUser where user_name=?";
            return JDBCUtil.queryRunner().query(selectSQL, new BeanHandler<NormalUser>(NormalUser.class), user_name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    //�����ͨ�û�
    public int insert(NormalUser normal_user) {
        try {
            String insertSQL = "INSERT INTO NormalUser(user_name,user_password,department) values(?,?,?)";
            JDBCUtil.queryRunner().update(insertSQL, normal_user.getUser_name(), normal_user.getUser_password(), normal_user.getDepartment());
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }

    }


    //�����û�id�鿴�û���Ϣ
    public NormalUser select(int user_id) {
        try {
            String selectSQL = "select * from NormalUser where user_id=?";
            return JDBCUtil.queryRunner().query(selectSQL, new BeanHandler<NormalUser>(NormalUser.class), user_id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //�鿴�����û�
    public List<NormalUser> selectAll() {
        try {
            String selectSQL = "select * from NormalUser";
            return JDBCUtil.queryRunner().query(selectSQL, new BeanListHandler<NormalUser>(NormalUser.class));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //����idɾ���û�
    public int delete(int i) {
        String deleteSQL = "delete from NormalUser where user_id=?";
        try {
            JDBCUtil.queryRunner().update(deleteSQL, i);
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
    }

    //����id�����û���Ϣ
    public int update(NormalUser normalUser, int user_id) {
        String updateSQL = "UPDATE NormalUser SET user_name=?,user_password=?,department=? where user_id=?";
        try {
            JDBCUtil.queryRunner().update(updateSQL, normalUser.getUser_name(), normalUser.getUser_password(), normalUser.getDepartment(), user_id);
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
    }
}
