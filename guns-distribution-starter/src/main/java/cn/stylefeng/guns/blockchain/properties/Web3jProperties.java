package cn.stylefeng.guns.blockchain.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

/**
 * Project Name  guns-distribution
 * File Name     Web3jProperties
 * Package Name  cn.stylefeng.guns.blockchain.properties
 * Date          2021/11/18 4:32 下午
 * Project Desc   
 * Copyright (c) 2021, Baiyuetong Corp. All Rights Reserved.
 * @author weijun
 */
@Data
@Component
@ConfigurationProperties(prefix = "blockchain")
public class Web3jProperties {
    String     rpc;
    BigInteger walletUnlockSecond;
}
