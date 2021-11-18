package cn.stylefeng.guns.blockchain.service;

import cn.stylefeng.guns.blockchain.contract.Ownable;
import cn.stylefeng.guns.blockchain.contract.Panama;
import cn.stylefeng.guns.blockchain.utils.BlockChainUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.tx.Contract;

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
    public void deployPanama () {
        Credentials credentials = BlockChainUtils.loadCredentials("0x287553d76483550e7a713e417d5ec0a5fa226b4677e002ce58fc72eb2ea7162d");
        RemoteCall<Panama> deploy = Contract.deployRemoteCall(Panama.class,
                web3j,
                credentials,
                BigInteger.valueOf(10000000),
                BigInteger.valueOf(5000000),
                Panama.BINARY,
                null);
        try {
            Panama ownable = deploy.send();
            ownable.isValid();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 发行一个新币
    public void deployOwnable () {
        Credentials credentials = BlockChainUtils.loadCredentials("0x287553d76483550e7a713e417d5ec0a5fa226b4677e002ce58fc72eb2ea7162d");
        RemoteCall<Ownable> deploy = Contract.deployRemoteCall(Ownable.class,
                web3j,
                credentials,
                BigInteger.valueOf(10000000),
                BigInteger.valueOf(5000000),
                Ownable.BINARY,
                null);
        try {
            Ownable ownable = deploy.send();
            ownable.isValid();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
