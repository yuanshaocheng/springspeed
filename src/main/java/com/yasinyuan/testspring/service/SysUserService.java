package com.yasinyuan.testspring.service;
import com.yasinyuan.testspring.model.SysUser;
import com.yasinyuan.testspring.core.Service;


/**
 * Created by YasinYuan on 2018/11/12.
 */
public interface SysUserService extends Service<SysUser> {

    SysUser queryByUserName(String username);
}
