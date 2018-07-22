package dao;

import Util.JDBCUtil;
import entity.Notice;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
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

    //���ݹ���id�鿴��������
    public Notice select(int i) {
        try {
            String selectSQL = "select * from notice where notice_id=?";
            return JDBCUtil.queryRunner().query(selectSQL, new BeanHandler<Notice>(Notice.class), i);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //���ݹ���idɾ������
    public int delete(int i) {
        String deleteSQL="delete from notice where notice_id=?";
        try {
            JDBCUtil.queryRunner().update(deleteSQL, i);
            return  0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
    }

    //���ݹ���id���¹���
    public int update(Notice notice,int notice_id) {
        String updateSQL="UPDATE notice SET title=?,notice=?,department=? where notice_id=?";
        try {
            JDBCUtil.queryRunner().update(updateSQL, notice.getTitle(),notice.getNotice(),notice.getDepartment(),notice_id);
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
    }

    //��������
    public int insert(Notice notice) {
        String insertSQL="insert into notice(title,notice,department) values(?,?,?);";
        try {
            JDBCUtil.queryRunner().update(insertSQL, notice.getTitle(),notice.getNotice(),notice.getDepartment());
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
    }

}
