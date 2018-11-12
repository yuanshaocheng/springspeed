package com.yasinyuan.testspring.service.impl;

import com.yasinyuan.testspring.dao.SysUserTokenMapper;
import com.yasinyuan.testspring.model.SysUserToken;
import com.yasinyuan.testspring.service.SysUserTokenService;
import com.yasinyuan.testspring.core.AbstractService;
import com.yasinyuan.testspring.shiro.TokenGenerator;
import com.yasinyuan.testspring.tools.R;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;


/**
 * Created by YasinYuan on 2018/11/12.
 */
@Service
@Transactional
public class SysUserTokenServiceImpl extends AbstractService<SysUserToken> implements SysUserTokenService {

    //12小时后过期
    private final static int EXPIRE = 3600 * 12;

    @Resource
    private SysUserTokenMapper sysUserTokenMapper;


    @Override
    public R createToken(long userId) {
        //生成一个token
        String token = TokenGenerator.generateValue();

        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

        //判断是否生成过token
        SysUserToken tokenEntity = sysUserTokenMapper.selectByPrimaryKey(userId);

        if(tokenEntity == null){
            tokenEntity = new SysUserToken();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //保存token
            sysUserTokenMapper.insert(tokenEntity);
        }else{
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //更新token
            sysUserTokenMapper.updateByPrimaryKey(tokenEntity);
        }

        R r = R.ok().put("token", token).put("expire", EXPIRE);

        return r;
    }

    @Override
    public void logout(long userId) {
        //生成一个token
        String token = TokenGenerator.generateValue();

        //修改token
        SysUserToken tokenEntity = new SysUserToken();
        tokenEntity.setUserId(userId);
        tokenEntity.setToken(token);
        sysUserTokenMapper.updateByPrimaryKey(tokenEntity);
    }
}
