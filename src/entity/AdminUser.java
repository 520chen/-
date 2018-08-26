package entity;

import lombok.*;

/*
*���Ĺ����û�ʵ����
* */
@ToString
@NoArgsConstructor
public class AdminUser {
    //���Ĺ����û�ID
    private int AdminUser_id;
    //���Ĺ����û���
    private String user_name;
    //���Ĺ����û�����
    private String user_password;
    //���Ĺ����û�����
    private String department;

    public int getAdminUser_id() {
        return AdminUser_id;
    }
    public String getUser_name() {
        return user_name;
    }
    public String getUser_password() {
        return user_password;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public AdminUser(String user_name, String user_password, String department) {
        this.user_name = user_name;
        this.user_password = user_password;
        this.department = department;
    }
}
