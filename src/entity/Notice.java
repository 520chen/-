package entity;

/*
 * ����ʵ����
 * */
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

    public Notice() {
    }

    public Notice(int notice_id, String title, String notice, String department, String release_time) {
        this.notice_id = notice_id;
        this.title = title;
        this.notice = notice;
        this.department = department;
        this.release_time = release_time;
    }

    public Notice(String title, String department, String notice) {
        this.title = title;
        this.notice = notice;
        this.department = department;
    }

    public int getNotice_id() {
        return notice_id;
    }

    public void setNotice_id(int notice_id) {
        this.notice_id = notice_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRelease_time() {
        return release_time;
    }

    public void setRelease_time(String release_time) {
        this.release_time = release_time;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "notice_id=" + notice_id +
                ", title='" + title + '\'' +
                ", notice='" + notice + '\'' +
                ", department='" + department + '\'' +
                ", release_time='" + release_time + '\'' +
                '}';
    }
}
