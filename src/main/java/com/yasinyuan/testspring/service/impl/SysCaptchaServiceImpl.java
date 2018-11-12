package com.yasinyuan.testspring.service.impl;

import com.google.code.kaptcha.Producer;
import com.yasinyuan.testspring.dao.SysCaptchaMapper;
import com.yasinyuan.testspring.model.SysCaptcha;
import com.yasinyuan.testspring.service.SysCaptchaService;
import com.yasinyuan.testspring.core.AbstractService;
import com.yasinyuan.testspring.tools.DateUtils;
import com.yasinyuan.testspring.tools.exception.RRException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.awt.image.BufferedImage;
import java.util.Date;


/**
 * Created by YasinYuan on 2018/11/05.
 */
@Service
@Transactional
public class SysCaptchaServiceImpl extends AbstractService<SysCaptcha> implements SysCaptchaService {
    @Resource
    private SysCaptchaMapper sysCaptchaMapper;
    @Resource
    private Producer producer;

    /**
     * js生成uuid算法
     * function getUUID() {
     * 	var s = [];
     * 	var hexDigits = "0123456789abcdef";
     * 	for (var i = 0; i < 36; i++) {
     * 		s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
     *        }
     * 	s[14] = "4";
     * 	s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1);
     *
     * 	s[8] = s[13] = s[18] = s[23] = "-";
     *
     * 	var uuid = s.join("");
     * 	return uuid;
     * }
    */

    @Override
    public BufferedImage getCaptcha(String uuid) {
        if(StringUtils.isBlank(uuid)){
            throw new RRException("uuid不能为空");
        }
        //生成文字验证码
        String code = producer.createText();

        SysCaptcha captchaEntity = new SysCaptcha();
        captchaEntity.setUuid(uuid);
        captchaEntity.setCode(code);
        //5分钟后过期
        captchaEntity.setExpireTime(DateUtils.addDateMinutes(new Date(), 5));
        sysCaptchaMapper.insert(captchaEntity);
        return producer.createImage(code);
    }
    @Override
    public boolean validate(String uuid, String code) {
        SysCaptcha captchaEntity = sysCaptchaMapper.selectByPrimaryKey(uuid);
        if(captchaEntity == null){
            return false;
        }
        //删除验证码
        sysCaptchaMapper.deleteByIds(uuid);

        if(captchaEntity.getCode().equalsIgnoreCase(code) && captchaEntity.getExpireTime().getTime() >= System.currentTimeMillis()){
            return true;
        }
        return false;
    }
}
