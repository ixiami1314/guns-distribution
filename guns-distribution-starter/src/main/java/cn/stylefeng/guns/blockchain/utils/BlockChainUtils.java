package cn.stylefeng.guns.blockchain.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import org.web3j.crypto.*;

import java.io.IOException;

/**
 * Project Name  guns-distribution
 * File Name     BlockChainUtils
 * Package Name  cn.stylefeng.guns.blockchain.utils
 * Date          2021/11/18 4:45 下午
 * Project Desc   
 * Copyright (c) 2021, Baiyuetong Corp. All Rights Reserved.
 * @author weijun
 */

public class BlockChainUtils {
    /***
     * 加载钱包对象的四种方式
     * @param privateKey
     * @return
     */
    public static Credentials loadCredentials (String privateKey) {
        return Credentials.create(privateKey);
    }

    public static Credentials loadCredentials (ECKeyPair keyPair) {
        return Credentials.create(keyPair);
    }

    public static Credentials loadCredentials (String password, String keyStoreUrl) throws IOException, CipherException {
        return WalletUtils.loadCredentials(password, keyStoreUrl);
    }

    public static Credentials loadCredentialsByString (String password, String keyStoreJson) throws IOException, CipherException {
        WalletFile walletFile = new ObjectMapper().readValue(keyStoreJson, WalletFile.class);
        return Credentials.create(Wallet.decrypt(password, walletFile));
    }
}
