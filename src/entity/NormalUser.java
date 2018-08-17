package entity;

import lombok.Getter;
import lombok.Setter;

/*
 * ��ͨ�û�ʵ����
 * */
@Setter@Getter
public class NormalUser {
    //�û�ID
    private int user_id;
    //�û���
    private String user_name;
    //�û�����
    private String user_password;
    //��������
    private String department;


    public NormalUser(String user_name, String user_password, String department) {
        this.user_name = user_name;
        this.user_password = user_password;
        this.department = department;
    }

    public NormalUser() {
    }

    public NormalUser(int user_id, String user_name, String user_password, String department) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.department = department;
    }

    @Override
    public String toString() {
        return "NormalUser{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
