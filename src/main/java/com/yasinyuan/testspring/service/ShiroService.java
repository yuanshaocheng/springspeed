package com.yasinyuan.testspring.service;

import com.yasinyuan.testspring.model.SysUser;
import com.yasinyuan.testspring.model.SysUserToken;

import java.util.Set;

public interface ShiroService {
    /**
     * 获取用户权限列表
     */
    Set<String> getUserPermissions(long userId);

    /**
     * 根据token查询token记录
     */
    SysUserToken queryByToken(String token);

    /**
     * 根据用户ID，查询用户
     */
    SysUser queryUser(Long userId);
}
