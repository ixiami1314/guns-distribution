package cn.stylefeng.guns.blockchain.param;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Project Name  guns-distribution
 * File Name     QRCodeParam
 * Package Name  cn.stylefeng.guns.blockchain.param
 * Date          2021/11/20 11:31 上午
 * Project Desc   
 * Copyright (c) 2021, Baiyuetong Corp. All Rights Reserved.
 * @author weijun
 */

@Data
public class QRCodeParam implements Serializable {
    String address;
    String tokenSymbol;
    BigInteger amount;
}
