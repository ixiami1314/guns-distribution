package cn.stylefeng.guns.config.blockchain;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.crypto.*;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Project Name  guns-distribution
 * File Name     Web3jService
 * Package Name  cn.stylefeng.guns.config.blockchain
 * Date          2021/11/18 1:50 下午
 * Project Desc   
 * Copyright (c) 2021, Baiyuetong Corp. All Rights Reserved.
 * @author weijun
 */

@Service
public class Web3jService {

    @Value("${blockchain.rpc}")
    String rpc;

    Web3j web3j = Web3j.build(new HttpService(rpc));

    /***
     * 加载钱包对象的四种方式
     * @param privateKey
     * @return
     */
    public Credentials loadCredentials (String privateKey) {
        return Credentials.create(privateKey);
    }

    public Credentials loadCredentials (ECKeyPair keyPair) {
        return Credentials.create(keyPair);
    }

    public Credentials loadCredentials (String password, String keyStoreUrl) throws IOException, CipherException {
        return WalletUtils.loadCredentials(password, keyStoreUrl);
    }

    public Credentials loadCredentialsByString (String password, String keyStoreJson) throws IOException, CipherException {
        WalletFile walletFile = new ObjectMapper().readValue(keyStoreJson, WalletFile.class);
        return Credentials.create(Wallet.decrypt(password, walletFile));
    }

    /***
     * 获取余额
     * @param address
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
}
