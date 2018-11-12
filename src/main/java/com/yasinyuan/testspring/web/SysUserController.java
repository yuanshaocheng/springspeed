package com.yasinyuan.testspring.web;
import com.yasinyuan.testspring.model.SysLoginForm;
import com.yasinyuan.testspring.service.SysCaptchaService;
import com.yasinyuan.testspring.service.SysUserTokenService;
import com.yasinyuan.testspring.tools.R;
import com.yasinyuan.testspring.model.SysUser;
import com.yasinyuan.testspring.service.SysUserService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

/**
* Created by YasinYuan on 2018/11/12.
*/
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController{
    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysCaptchaService sysCaptchaService;
    @Resource
    private SysUserTokenService sysUserTokenService;

    /**
     * 登录，form表单提交方式（json序列化）
     */
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody SysLoginForm form)throws IOException {
        boolean captcha = sysCaptchaService.validate(form.getUuid(), form.getCaptcha());
        if(!captcha){
            return R.error("验证码不正确");
        }
        //用户信息
        SysUser user = sysUserService.queryByUserName(form.getUsername());

        //账号不存在、密码错误
        if(user == null || !user.getPassword().equals(new Sha256Hash(form.getPassword(), user.getSalt()).toHex())) {
            return R.error("账号或密码不正确");
        }

        //账号锁定
        if(user.getStatus() == 0){
            return R.error("账号已被锁定,请联系管理员");
        }
        logger.error(user.getUserId()+"");
        //生成token，并保存到数据库
        R r = sysUserTokenService.createToken(user.getUserId());
        return r;
    }
}
