package cn.stylefeng.guns.blockchain.contract;

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
public class MyGasProvider implements ContractGasProvider {

    /**
     * 这里传入的是合约的名称
     * 用于区分不同合约的不同价格
     *
     * @param s
     * @return
     */
    @Override
    public BigInteger getGasPrice(String s) {
        if (Ownable.FUNC_TRANSFEROWNERSHIP.equals(s)) {
            return BigInteger.valueOf(50000000);
        } else if (Panama.FUNC_ALLOWANCE.equals(s)) {
            return BigInteger.valueOf(50000000);
        } else {
            return BigInteger.valueOf(50000000);
        }
    }

    @Override
    public BigInteger getGasPrice() {
        return BigInteger.valueOf(50000000);
    }

    /**
     * 这里传入的是合约的名称
     * 用于区分不同合约的不同数量
     *
     * @param s
     * @return
     */
    @Override
    public BigInteger getGasLimit(String s) {
        if (Ownable.FUNC_TRANSFEROWNERSHIP.equals(s)) {
            return BigInteger.valueOf(8000000);
        } else if (Panama.FUNC_ALLOWANCE.equals(s)) {
            return BigInteger.valueOf(8000000);
        } else {
            return BigInteger.valueOf(8000000);
        }
    }

    @Override
    public BigInteger getGasLimit() {
        return BigInteger.valueOf(8000000);
    }
}
