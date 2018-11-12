package com.yasinyuan.testspring.service;
import com.yasinyuan.testspring.model.SysCaptcha;
import com.yasinyuan.testspring.core.Service;

import java.awt.image.BufferedImage;


/**
 * Created by YasinYuan on 2018/11/05.
 */
public interface SysCaptchaService extends Service<SysCaptcha> {

    /**
     * 获取图片验证码
     */
    BufferedImage getCaptcha(String uuid);

    /**
     * 验证码效验
     * @param uuid  uuid
     * @param code  验证码
     * @return  true：成功  false：失败
     */
    boolean validate(String uuid, String code);
}
