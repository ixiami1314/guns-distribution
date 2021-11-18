package cn.stylefeng.guns;

import cn.stylefeng.guns.blockchain.contract.Ownable;
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

import java.util.Arrays;

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

    @Override
    public void run(ApplicationArguments args) throws Exception {
        transferOwnership();
    }

    public void transferOwnership () {
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
