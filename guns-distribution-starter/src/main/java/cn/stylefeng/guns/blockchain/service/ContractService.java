package cn.stylefeng.guns.blockchain.service;

import cn.stylefeng.guns.blockchain.contract.Ownable;
import cn.stylefeng.guns.blockchain.utils.BlockChainUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.tx.Contract;
import org.web3j.utils.Convert;

import java.math.BigInteger;

/**
 * Project Name  guns-distribution
 * File Name     ContractService
 * Package Name  cn.stylefeng.guns.blockchain.service
 * Date          2021/11/18 7:07 下午
 * Project Desc  合约管理 
 * Copyright (c) 2021, Baiyuetong Corp. All Rights Reserved.
 * @author weijun
 */
@Service
@Slf4j
public class ContractService {

    @Autowired
    Web3j web3j;

    // 发行一个新币
    public void deploy () {
        Credentials credentials = BlockChainUtils.loadCredentials("0xd298241263f352f3c2c4a8f1128b6d6739f6caaccae20b04f3169a241a520fbc");
        RemoteCall<Ownable> deploy = Contract.deployRemoteCall(Ownable.class,
                web3j,
                credentials,
                BigInteger.valueOf(3000000),
                BigInteger.valueOf(5201314),
                "Panama Token",
                "PT");
        try {
            Ownable ownable = deploy.send();
            ownable.isValid();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
