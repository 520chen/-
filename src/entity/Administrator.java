package entity;

import lombok.Getter;
import lombok.Setter;

/*
* ����Աʵ����
* */
@Setter@Getter
public class Administrator {
    //����Ա�˺�
    private String user_name;
    //����Ա����
    private String user_password;

    @Override
    public String toString() {
        return "Administrator{" +
                "user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                '}';
    }

    public Administrator() {

    }

    public Administrator(String user_name, String user_password) {

        this.user_name = user_name;
        this.user_password = user_password;
    }
}
