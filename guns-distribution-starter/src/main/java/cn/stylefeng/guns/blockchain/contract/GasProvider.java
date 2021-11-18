package cn.stylefeng.guns.blockchain.contract;

import org.springframework.stereotype.Component;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;

/**
 * Project Name  guns-distribution
 * File Name     GasProvider
 * Package Name  cn.stylefeng.guns.blockchain.contract
 * Date          2021/11/18 - 11:07 下午
 * Project Desc
 * Copyright (c) 2021, baiyuetong.cn Corp. All Rights Reserved.
 *
 * @author weijun
 */
@Component
public class GasProvider implements ContractGasProvider {

    @Override
    public BigInteger getGasPrice(String s) {
        return BigInteger.valueOf(Long.valueOf(s));
    }

    @Override
    public BigInteger getGasPrice() {
        return BigInteger.valueOf(500000L);
    }

    @Override
    public BigInteger getGasLimit(String s) {
        return BigInteger.valueOf(Long.valueOf(s));
    }

    @Override
    public BigInteger getGasLimit() {
        return BigInteger.valueOf(500000L);
    }
}
