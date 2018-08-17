package entity;

import lombok.Getter;
import lombok.Setter;

/*
 * ����ʵ����
 * */
@Getter@Setter
public class Notice {
    //����id
    private int notice_id;
    //���ı���
    private String title;
    //��������
    private String notice;
    //������Щ���ſɼ�
    private String department;
    //���ķ���ʱ��
    private String release_time;
    //����ĳ�˿��Լ�
    private String people;


    public Notice(String title, String department, String notice) {
        this.title = title;
        this.notice = notice;
        this.department = department;
    }


    public Notice(String title, String notice, String department, String people) {
        this.title = title;
        this.notice = notice;
        this.department = department;
        this.people = people;

    }

    @Override
    public String toString() {
        return "Notice{" +
                "notice_id=" + notice_id +
                ", title='" + title + '\'' +
                ", notice='" + notice + '\'' +
                ", department='" + department + '\'' +
                ", release_time='" + release_time + '\'' +
                ", people='" + people + '\'' +
                '}';
    }
}
