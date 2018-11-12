package com.yasinyuan.testspring.web;

import com.yasinyuan.testspring.model.SysUser;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller公共组件
 */

public class AbstractController {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    protected SysUser getUser() {
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }

    protected Long getUserId() {
        return getUser().getUserId();
    }
}
