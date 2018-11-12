package com.yasinyuan.testspring.service.impl;

import com.yasinyuan.testspring.dao.SysUserMapper;
import com.yasinyuan.testspring.model.SysUser;
import com.yasinyuan.testspring.service.SysUserService;
import com.yasinyuan.testspring.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by YasinYuan on 2018/11/12.
 */
@Service
@Transactional
public class SysUserServiceImpl extends AbstractService<SysUser> implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser queryByUserName(String username) {
        return sysUserMapper.queryByUserName(username);
    }
}
