package cn.stylefeng.guns.blockchain.config;

import cn.stylefeng.guns.blockchain.contract.Ownable;
import cn.stylefeng.guns.blockchain.contract.Panama;
import cn.stylefeng.guns.blockchain.properties.Web3jProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.io.IOException;
import java.math.BigInteger;

/**
 * Project Name  guns-distribution
 * File Name     ContractConfig
 * Package Name  cn.stylefeng.guns.blockchain.config
 * Date          2021/11/18 - 10:45 下午
 * Project Desc  智能合约配置
 * Copyright (c) 2021, baiyuetong.cn Corp. All Rights Reserved.
 *
 * @author weijun
 */
@Configuration
@Slf4j
public class ContractConfig {

    @Autowired
    Web3jProperties properties;

    @Autowired
    Web3j web3j;

    @Autowired
    ContractGasProvider gasProvider;

//    @Bean
//    Panama panama () throws IOException {
//        Web3ClientVersion web3ClientVersion  = web3j.web3ClientVersion().send();
//        log.info("- client version is {}", web3ClientVersion.getWeb3ClientVersion());
//        // 以某用户的身份去调用合约
//        TransactionManager transactionManager = new ClientTransactionManager(web3j, properties.getContractPrivateKey());
//        Panama ownable = Panama.load(properties.getContractPanama(), web3j, transactionManager, gasProvider);
//        return ownable;
//    }
//
//    @Bean
//    Ownable ownable () throws IOException {
//        Web3ClientVersion web3ClientVersion  = web3j.web3ClientVersion().send();
//        log.info("- client version is {}", web3ClientVersion.getWeb3ClientVersion());
//        // 以某用户的身份去调用合约
//        TransactionManager transactionManager = new ClientTransactionManager(web3j, properties.getContractPrivateKey());
//        Ownable ownable = Ownable.load(properties.getContractOwnable(), web3j, transactionManager, gasProvider);
//        return ownable;
//    }

    @Bean
    @Scope("prototype")
    public EthFilter ethFilter () throws IOException {
        Request<?, EthBlockNumber> request = web3j.ethBlockNumber();
        BigInteger fromblock = request.send().getBlockNumber();
        return new EthFilter(DefaultBlockParameter.valueOf(fromblock),
                DefaultBlockParameterName.LATEST,
                properties.getContractOwnable());
    }
}
