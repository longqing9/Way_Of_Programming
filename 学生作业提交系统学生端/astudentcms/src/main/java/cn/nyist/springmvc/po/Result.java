package cn.nyist.springmvc.po;

public class Result {
    private String reid;

    private Long rsno;

    private String opid;

    private String reurl;

    private Integer rescore;

    private String retext;

    public String getReid() {
        return reid;
    }

    public void setReid(String reid) {
        this.reid = reid == null ? null : reid.trim();
    }

    public Long getRsno() {
        return rsno;
    }

    public void setRsno(Long rsno) {
        this.rsno = rsno;
    }

    public String getOpid() {
        return opid;
    }

    public void setOpid(String opid) {
        this.opid = opid == null ? null : opid.trim();
    }

    public String getReurl() {
        return reurl;
    }

    public void setReurl(String reurl) {
        this.reurl = reurl == null ? null : reurl.trim();
    }

    public Integer getRescore() {
        return rescore;
    }

    public void setRescore(Integer rescore) {
        this.rescore = rescore;
    }

    public String getRetext() {
        return retext;
    }

    public void setRetext(String retext) {
        this.retext = retext == null ? null : retext.trim();
    }
}