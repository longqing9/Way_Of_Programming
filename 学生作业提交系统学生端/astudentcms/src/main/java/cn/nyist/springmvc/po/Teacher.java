package cn.nyist.springmvc.po;

public class Teacher {
    private Long tno;

    private String tname;

    private String tsex;

    private String tsubject;

    private String ttel;

    private String tpic;

    public Long getTno() {
        return tno;
    }

    public void setTno(Long tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex == null ? null : tsex.trim();
    }

    public String getTsubject() {
        return tsubject;
    }

    public void setTsubject(String tsubject) {
        this.tsubject = tsubject == null ? null : tsubject.trim();
    }

    public String getTtel() {
        return ttel;
    }

    public void setTtel(String ttel) {
        this.ttel = ttel == null ? null : ttel.trim();
    }

    public String getTpic() {
        return tpic;
    }

    public void setTpic(String tpic) {
        this.tpic = tpic == null ? null : tpic.trim();
    }
}