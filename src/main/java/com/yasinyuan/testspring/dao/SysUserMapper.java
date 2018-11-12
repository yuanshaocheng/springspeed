package com.yasinyuan.testspring.dao;

import com.yasinyuan.testspring.core.Mapper;
import com.yasinyuan.testspring.model.SysUser;
import org.apache.ibatis.annotations.Select;

public interface SysUserMapper extends Mapper<SysUser> {

    @Select("select * from sys_user where username=#{username}")
    SysUser queryByUserName(String username);
}