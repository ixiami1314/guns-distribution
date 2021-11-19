package cn.stylefeng.guns.blockchain.config;

import cn.stylefeng.guns.blockchain.properties.BlockChainProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.EthBlockNumber;

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

//    @Bean
//    Ownable ownable (BlockChainProperties properties) throws IOException {
//        Web3ClientVersion web3ClientVersion  = web3j.web3ClientVersion().send();
//        log.info("- client version is {}", web3ClientVersion.getWeb3ClientVersion());
//        // 以某用户的身份去调用合约
//        TransactionManager transactionManager = new ClientTransactionManager(web3j, properties.getContractPrivateKey());
//        Ownable ownable = Ownable.load(properties.getContractOwnable(), web3j, transactionManager, gasProvider);
//        return ownable;
//    }

    /***
     * 定义一个合约监听器
     *
     * @param web3j
     * @param properties
     * @return
     * @throws IOException
     */
    @Bean
    @Scope("prototype")
    public EthFilter ethFilter (Web3j web3j, BlockChainProperties properties) throws IOException {
        Request<?, EthBlockNumber> request = web3j.ethBlockNumber();
        BigInteger fromblock = request.send().getBlockNumber();
        return new EthFilter(DefaultBlockParameter.valueOf(fromblock),
                DefaultBlockParameterName.LATEST,
                properties.getOwnableContractAddress());
    }
}
