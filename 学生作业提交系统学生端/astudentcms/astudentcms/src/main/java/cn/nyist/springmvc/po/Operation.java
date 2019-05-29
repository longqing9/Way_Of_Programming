package cn.nyist.springmvc.po;

import java.util.Date;

public class Operation {
    private String opid;

    private String optop;

    private String opsubid;

    private Date opstoptime;

    private String videourl;

    private String optext;

    public String getOpid() {
        return opid;
    }

    public void setOpid(String opid) {
        this.opid = opid == null ? null : opid.trim();
    }

    public String getOptop() {
        return optop;
    }

    public void setOptop(String optop) {
        this.optop = optop == null ? null : optop.trim();
    }

    public String getOpsubid() {
        return opsubid;
    }

    public void setOpsubid(String opsubid) {
        this.opsubid = opsubid == null ? null : opsubid.trim();
    }

    public Date getOpstoptime() {
        return opstoptime;
    }

    public void setOpstoptime(Date opstoptime) {
        this.opstoptime = opstoptime;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl == null ? null : videourl.trim();
    }

    public String getOptext() {
        return optext;
    }

    public void setOptext(String optext) {
        this.optext = optext == null ? null : optext.trim();
    }
}