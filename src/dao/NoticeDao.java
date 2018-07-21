package dao;

import Util.JDBCUtil;
import entity.NormalUser;
import entity.Notice;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;
/*
* �������ݿ����
* */
public class NoticeDao {
    //���ݲ��Ų鿴����
    public List<Notice> selectAll(String department) {
        try {
            String selectSQL = "select * from notice where department=? or department=?";
            return JDBCUtil.queryRunner().query(selectSQL, new BeanListHandler<Notice>(Notice.class),department,"ȫ������");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
