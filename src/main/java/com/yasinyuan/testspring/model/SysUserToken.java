package com.yasinyuan.testspring.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user_token")
public class SysUserToken {
    @Id
    private Long userid;

    /**
     * token
     */
    private String token;

    /**
     * 过期时间
     */
    private Date expiretime;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * @return userid
     */
    public Long getUserId() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserId(Long userid) {
        this.userid = userid;
    }

    /**
     * 获取token
     *
     * @return token - token
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置token
     *
     * @param token token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 获取过期时间
     *
     * @return expiretime - 过期时间
     */
    public Date getExpireTime() {
        return expiretime;
    }

    /**
     * 设置过期时间
     *
     * @param expiretime 过期时间
     */
    public void setExpireTime(Date expiretime) {
        this.expiretime = expiretime;
    }

    /**
     * 获取更新时间
     *
     * @return updatetime - 更新时间
     */
    public Date getUpdateTime() {
        return updatetime;
    }

    /**
     * 设置更新时间
     *
     * @param updatetime 更新时间
     */
    public void setUpdateTime(Date updatetime) {
        this.updatetime = updatetime;
    }
}