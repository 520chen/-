package entity;

import lombok.Getter;
import lombok.Setter;

/*
*���Ĺ����û�ʵ����
* */
@Setter@Getter
public class AdminUser {
    //���Ĺ����û�ID
    private int AdminUser_id;
    //���Ĺ����û���
    private String user_name;
    //���Ĺ����û�����
    private String user_password;
    //���Ĺ����û�����
    private String department;

    public AdminUser(String user_name, String user_password, String department) {
        this.user_name = user_name;
        this.user_password = user_password;
        this.department = department;
    }

    public AdminUser(int adminUser_id, String user_name, String user_password, String department) {
        AdminUser_id = adminUser_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.department = department;
    }

    public AdminUser() {
    }

    @Override
    public String toString() {
        return "AdminUser{" +
                "AdminUser_id=" + AdminUser_id +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
