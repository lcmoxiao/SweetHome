package com.jlp.pojo;

import java.util.Date;

public class Prison {
    private Integer prisonid;

    private Integer userid;

    private Date createtime;

    public Integer getPrisonid() {
        return prisonid;
    }

    public void setPrisonid(Integer prisonid) {
        this.prisonid = prisonid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}