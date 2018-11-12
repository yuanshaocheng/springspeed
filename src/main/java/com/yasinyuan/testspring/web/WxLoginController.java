package com.yasinyuan.testspring.web;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.yasinyuan.testspring.tools.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/wxlogin")
public class WxLoginController {

    @Resource
    private WxMaService wxService;

    /*consumes = "multipart/form-data",*/
    @PostMapping(value = "checkAnswer",  produces = "application/json")
    @ApiOperation(value = "微信登陆对应接口", notes = "使用微信小程序code换取openid")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "wx.login对应code", required = true, dataType = "String"),
    })
    public R checkAnswer(@RequestParam String code){
        Map<String, Object> map = new HashMap<>();
        WxMaJscode2SessionResult wxMaJscode2SessionResult;
        try {
            wxMaJscode2SessionResult = wxService.getUserService().getSessionInfo(code);
            return R.ok().put("data",wxMaJscode2SessionResult.getOpenid());
        } catch (WxErrorException e) {
            return R.error("登陆失败！"+e.getMessage());
        }
    }

}
