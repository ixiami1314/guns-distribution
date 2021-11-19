package cn.stylefeng.guns;

import cn.stylefeng.guns.blockchain.contract.Ownable;
import cn.stylefeng.guns.blockchain.properties.BlockChainProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Project Name  guns-distribution
 * File Name     ServiceRunner
 * Package Name  cn.stylefeng.guns
 * Date          2021/11/18 - 11:44 下午
 * Project Desc
 * Copyright (c) 2021, baiyuetong.cn Corp. All Rights Reserved.
 *
 * @author weijun
 */

@Component
@Slf4j
public class ServiceRunner implements ApplicationRunner {

    @Autowired
    Web3j web3j;

    @Autowired
    EthFilter ethFilter;

    @Autowired
    BlockChainProperties properties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        transferOwnership();
    }

    public void transferOwnership () {

        try {
            log.info("-------------------------------------------------");
            log.info("- 当前客户端结点地址 {}", properties.getRpc());
            log.info("- 当前客户端版本信息 {}", web3j.web3ClientVersion().send().getWeb3ClientVersion());
            log.info("- 链ID            {}", web3j.ethChainId().send().getChainId());
            log.info("- 区块数量         {}", web3j.ethBlockNumber().send().getBlockNumber());
            log.info("- 挖矿奖励帐户     {}", web3j.ethCoinbase().send().getAddress());
            log.info("- 是否在同步区块    {}", web3j.ethSyncing().send().isSyncing());
            log.info("- 是否在挖矿       {}", web3j.ethMining().send().isMining());
            log.info("- 当前 gas 价格    {}", web3j.ethGasPrice().send().getGasPrice());
            log.info("- 边接结点数       {}", web3j.netPeerCount().send().getQuantity());
            log.info("-------------------------------------------------");
        } catch (Exception ex) {
            log.info("------------- Blocak Chain ERROR ----------------");
        }

        Event event = new Event(Ownable.FUNC_TRANSFEROWNERSHIP,
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));

        ethFilter.addSingleTopic(EventEncoder.encode(event));
        log.info("- contract listening ... {}", event.getName());
        web3j.ethLogFlowable(ethFilter)
                .subscribe(logger -> {
                    log.info("receive upload pro auth event");
                });
    }
}
