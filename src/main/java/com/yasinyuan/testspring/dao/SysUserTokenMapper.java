package com.yasinyuan.testspring.dao;

import com.yasinyuan.testspring.core.Mapper;
import com.yasinyuan.testspring.model.SysUserToken;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SysUserTokenMapper extends Mapper<SysUserToken> {

    @Select("select * from sys_user_token where token=#{token}")
    SysUserToken queryByToken(@Param("token") String token);
}