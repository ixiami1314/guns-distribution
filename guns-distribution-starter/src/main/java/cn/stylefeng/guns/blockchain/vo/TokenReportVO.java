package cn.stylefeng.guns.blockchain.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Project Name  guns-distribution
 * File Name     TokenReportVO
 * Package Name  cn.stylefeng.guns.blockchain.vo
 * Date          2021/11/19 7:54 下午
 * Project Desc   
 * Copyright (c) 2021, Baiyuetong Corp. All Rights Reserved.
 * @author weijun
 */

@Data
public class TokenReportVO implements Serializable {
    String tokenSymbol;
    String tokenName;
    int tokenDecimals;
    BigInteger tokenTotalSupply;
}
