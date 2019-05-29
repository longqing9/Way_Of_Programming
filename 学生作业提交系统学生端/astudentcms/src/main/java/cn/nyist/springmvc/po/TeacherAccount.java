package cn.nyist.springmvc.po;

public class TeacherAccount {
    private Long tno;

    private String password;

    public Long getTno() {
        return tno;
    }

    public void setTno(Long tno) {
        this.tno = tno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}