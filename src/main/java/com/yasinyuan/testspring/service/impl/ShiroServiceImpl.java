package com.yasinyuan.testspring.service.impl;

import com.yasinyuan.testspring.dao.SysUserMapper;
import com.yasinyuan.testspring.dao.SysUserTokenMapper;
import com.yasinyuan.testspring.model.SysUser;
import com.yasinyuan.testspring.model.SysUserToken;
import com.yasinyuan.testspring.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserTokenMapper sysUserTokenMapper;

    //当用户分级权限时使用得到，在控制器中添加@RequiresPermissions("")的方法，需要此处授权
    @Override
    public Set<String> getUserPermissions(long userId) {

        //用户权限列表
        Set<String> permsSet = new HashSet<>();
        return permsSet;
    }
    @Override
    public SysUserToken queryByToken(String token) {
        return sysUserTokenMapper.queryByToken(token);
    }

    @Override
    public SysUser queryUser(Long userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }
}
