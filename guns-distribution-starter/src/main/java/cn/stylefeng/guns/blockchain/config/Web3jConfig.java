package cn.stylefeng.guns.blockchain.config;

import cn.stylefeng.guns.blockchain.properties.Web3jProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.http.HttpService;

/**
 * Project Name  guns-distribution
 * File Name     Web3jConfig
 * Package Name  cn.stylefeng.guns.blockchain.config
 * Date          2021/11/18 4:31 下午
 * Project Desc  配置基础的web3j 
 * Copyright (c) 2021, Baiyuetong Corp. All Rights Reserved.
 * @author weijun
 */

@Configuration
public class Web3jConfig {

    @Autowired
    Web3jProperties properties;

    @Bean
    Web3j web3j () {
        return Web3j.build(new HttpService(properties.getRpc()));
    }

    @Bean
    Admin admin () {
        return Admin.build(new HttpService(properties.getRpc()));
    }
}
