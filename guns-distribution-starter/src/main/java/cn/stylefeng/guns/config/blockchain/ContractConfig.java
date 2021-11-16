package cn.stylefeng.guns.config.blockchain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthFilter;
import org.web3j.protocol.http.HttpService;

import java.io.IOError;
import java.io.IOException;

/**
 * Project Name  guns-distribution
 * File Name     ContractConfig
 * Package Name  cn.stylefeng.guns.config.blockchain
 * Date          2021/11/16 7:00 下午
 * Project Desc  智能合约配置 
 * Copyright (c) 2021, Baiyuetong Corp. All Rights Reserved.
 * @author weijun
 */

@Configuration
public class ContractConfig {

    @Bean
    public Web3j web3j () {
        // 测试环境
        String ip = "https://rinkeby.infura.io/ws/v3/e3fa131a7aa3434a8cf4ceee317282a2";
//        String ip = "https://mainnet.infura.io/v3/e3fa131a7aa3434a8cf4ceee317282a2";
        return Web3j.build(new HttpService(ip));
    }

    @Bean(name = "inviteFilter")
    @Scope("prototype")
    public EthFilter ethFilter(Ownable ownable, Web3j web3j) throws IOException {

    }

    @Bean
    public Ownable ownable(Web3j web3j) throws IOException {
        Ownable ownable;
        String ownableAddress;
        return ownable;
    }
}
