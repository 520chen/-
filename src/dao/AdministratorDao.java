package dao;

import Util.JDBCUtil;
import entity.Administrator;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class AdministratorDao {
    //�����û����鿴�û���Ϣ
    public Administrator select(String user_name) {
        try {
            String selectSQL = "select * from Administrator where user_name=?";
            return JDBCUtil.queryRunner().query(selectSQL, new BeanHandler<Administrator>(Administrator.class), user_name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
