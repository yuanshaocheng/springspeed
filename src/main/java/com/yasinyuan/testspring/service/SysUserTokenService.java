package com.yasinyuan.testspring.service;
import com.yasinyuan.testspring.model.SysUserToken;
import com.yasinyuan.testspring.core.Service;
import com.yasinyuan.testspring.tools.R;


/**
 * Created by YasinYuan on 2018/11/12.
 */
public interface SysUserTokenService extends Service<SysUserToken> {

    /**
     * 生成token
     * @param userId  用户ID
     */
    R createToken(long userId);

    /**
     * 退出，修改token值
     * @param userId  用户ID
     */
    void logout(long userId);
}
