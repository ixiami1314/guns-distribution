package cn.stylefeng.guns.blockchain.service;

import cn.stylefeng.guns.blockchain.param.TransferParam;
import cn.stylefeng.guns.blockchain.properties.Web3jProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Project Name  guns-distribution
 * File Name     BlockChainService
 * Package Name  cn.stylefeng.guns.blockchain.service
 * Date          2021/11/18 4:41 下午
 * Project Desc   
 * Copyright (c) 2021, Baiyuetong Corp. All Rights Reserved.
 * @author weijun
 */
@Service
@Slf4j
public class BlockChainService {

    @Autowired
    Web3j web3j;

    @Autowired
    Admin admin;

    @Autowired
    Web3jProperties properties;

    /***
     * 获取余额
     * @param address     指定钱包地址
     * @return
     * @throws IOException
     */
    public String getETHBalance (String address) throws IOException {
        BigDecimal balance = new BigDecimal(web3j.ethGetBalance(address, DefaultBlockParameter.valueOf("LATEST")).send().getBalance());
        return balance.divide(new BigDecimal("10").pow(18)).toPlainString();
    }

    /**
     * 转帐交易
     * @param address      接收钱包地址
     * @param count        数量
     * @param credentials  转账钱包地址
     * @return
     * @throws Exception
     */
    public TransactionReceipt transferETH (String address, BigDecimal count, Credentials credentials) throws Exception {
        return Transfer.sendFunds(web3j, credentials, address, count, Convert.Unit.ETHER).send();
    }

    /**
     * 获取当前 nonce
     * @param address      需要查询的钱包地址
     * @return
     * @throws IOException
     */
    public String getNonce (String address) throws IOException {
        return web3j.ethGetTransactionCount(address, DefaultBlockParameterName.LATEST).send().getTransactionCount().toString();
    }

    /***
     * 发送一笔交易
     * @param param
     * @return
     */
    public String sendTransaction (TransferParam param) {
        BigInteger value = Convert.toWei(param.getValue(), Convert.Unit.ETHER).toBigInteger();
        try {
            PersonalUnlockAccount personalUnlockAccount = admin.personalUnlockAccount(param.getFromAddress(), param.getFromAddressPassword(), properties.getWalletUnlockSecond()).send();
            if (personalUnlockAccount.accountUnlocked()) {
                Transaction transaction = Transaction.createEtherTransaction(param.getFromAddress(), null, null, null, param.getToAddress(), value);
                EthSendTransaction ethSendTransaction = web3j.ethSendTransaction(transaction).send();
                log.info("交易完成，hash {}", ethSendTransaction.getTransactionHash());
                return ethSendTransaction.getTransactionHash();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

