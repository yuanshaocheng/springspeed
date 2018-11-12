package com.yasinyuan.testspring.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_captcha")
public class SysCaptcha {
    /**
     * uuid
     */
    @Id
    private String uuid;

    /**
     * 验证码
     */
    private String code;

    /**
     * 过期时间
     */
    private Date expiretime;

    /**
     * 获取uuid
     *
     * @return uuid - uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置uuid
     *
     * @param uuid uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取验证码
     *
     * @return code - 验证码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置验证码
     *
     * @param code 验证码
     */
    public void setCode(String code) {
        this.code = code;
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
}