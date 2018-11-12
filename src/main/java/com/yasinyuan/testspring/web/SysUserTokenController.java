package com.yasinyuan.testspring.web;

import com.yasinyuan.testspring.tools.R;
import com.yasinyuan.testspring.model.SysUserToken;
import com.yasinyuan.testspring.service.SysUserTokenService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
* Created by YasinYuan on 2018/11/12.
*/
@RestController
@RequestMapping("/sys/user/token")
public class SysUserTokenController extends AbstractController{
    @Resource
    private SysUserTokenService sysUserTokenService;


}
