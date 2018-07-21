package dao;

import Util.JDBCUtil;
import entity.AdminUser;
import entity.NormalUser;
import org.apache.commons.dbutils.handlers.BeanHandler;

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
}
