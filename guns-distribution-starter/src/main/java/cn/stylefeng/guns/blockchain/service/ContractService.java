package cn.stylefeng.guns.blockchain.service;

import cn.stylefeng.guns.blockchain.contract.MyGasProvider;
import cn.stylefeng.guns.blockchain.contract.Ownable;
import cn.stylefeng.guns.blockchain.contract.Panama;
import cn.stylefeng.guns.blockchain.properties.BlockChainProperties;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

import java.math.BigInteger;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

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

    @Autowired
    BlockChainProperties properties;

    @Autowired
    MyGasProvider gasProvider;

    // 发行一个新币
    public void deployPanama () {
        TransactionManager transactionManager = new ClientTransactionManager(web3j, properties.getContractDeployAddress());
        RemoteCall<Panama> deploy = Contract.deployRemoteCall(Panama.class,
                web3j,
                transactionManager,
                gasProvider,
                Panama.BINARY,
                null);
        try {
            Panama ownable = deploy.send();
            boolean result = ownable.isValid();
            log.info("- [智能合约] {} 部署 {}，地址为 {}", "Panama", result, ownable.getContractAddress());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 发行一个新币
    public void deployOwnable () {
        TransactionManager transactionManager = new ClientTransactionManager(web3j, properties.getContractDeployAddress());
        RemoteCall<Ownable> deploy = Contract.deployRemoteCall(Ownable.class,
                web3j,
                transactionManager,
                gasProvider,
                Ownable.BINARY,
                null);
        try {
            Ownable ownable = deploy.send();
            boolean result = ownable.isValid();
            log.info("- [智能合约] {} 部署 {}，地址为 {}", Ownable.FUNC_TRANSFEROWNERSHIP, result, ownable.getContractAddress());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 添加授权
    public TransactionReceipt transferOwnerShip (String address) {
        TransactionManager transactionManager = new ClientTransactionManager(web3j, address);
        Ownable ownable = Ownable.load(properties.getOwnableContractAddress(), web3j, transactionManager, BigInteger.valueOf(1000), BigInteger.valueOf(50));
        try {
            if (ownable.isValid()) {
                return ownable.transferOwnership(address).send();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 通过交易飘扬查询交易状态
     * @param transactionReceipt
     */
    public void transactionDetail (String transactionReceipt) {
        CompletableFuture<EthGetTransactionReceipt> future = web3j.ethGetTransactionReceipt(transactionReceipt).sendAsync();
        Future<EthGetTransactionReceipt> f = future.whenComplete((receipt, error) -> {
            if (error != null) {
                log.error("- [智能合约] 交易详情查询失败, {}", error.getLocalizedMessage());
                return ;
            }

            if (receipt.getResult() == null) {
                log.error("- [智能合约] 交易详情查询失败");
                return ;
            }

            log.info("- 交易查询结果 数量 {}", Integer.parseInt(receipt.getResult().getLogs().get(0).getData().substring(2, receipt.getResult().getLogs().get(0).getData().length()), 16));
        });
    }
}
