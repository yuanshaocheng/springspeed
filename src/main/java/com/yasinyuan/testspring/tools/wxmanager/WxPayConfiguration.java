package com.yasinyuan.testspring.tools.wxmanager;

import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Binary Wang
 */
@Configuration
@ConditionalOnClass(WxPayService.class)
@EnableConfigurationProperties(WxPayProperties.class)
public class WxPayConfiguration {
  @Autowired
  private WxPayProperties properties;

  @Bean
  @ConditionalOnMissingBean
  public WxPayConfig payConfig() {
    WxPayConfig payConfig = new WxPayConfig();
    payConfig.setAppId(properties.getAppId());
    payConfig.setMchId(properties.getMchId());
    payConfig.setMchKey(properties.getMchKey());
    payConfig.setKeyPath(properties.getKeyPath());

    return payConfig;
  }

  @Bean
  //@ConditionalOnMissingBean
  public WxPayService wxPayService(WxPayConfig payConfig) {
    WxPayService wxPayService = new WxPayServiceImpl();
    wxPayService.setConfig(payConfig);
    return wxPayService;
  }

}
