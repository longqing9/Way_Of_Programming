package cn.nyist.springmvc.po;

public class Class {
    private Long classid;

    private String classname;

    private Integer classcount;

    public Long getClassid() {
        return classid;
    }

    public void setClassid(Long classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public Integer getClasscount() {
        return classcount;
    }

    public void setClasscount(Integer classcount) {
        this.classcount = classcount;
    }
}