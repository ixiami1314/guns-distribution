package cn.stylefeng.guns.blockchain.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Project Name  guns-distribution
 * File Name     TransferParam
 * Package Name  cn.stylefeng.guns.blockchain.param
 * Date          2021/11/18 6:24 下午
 * Project Desc   
 * Copyright (c) 2021, Baiyuetong Corp. All Rights Reserved.
 * @author weijun
 */
@Data
@Builder
@AllArgsConstructor
public class TransferParam implements Serializable {
    @ApiModelProperty(value = "放款方", required = true)
    String     fromAddress;

    @ApiModelProperty(value = "放款方密码", required = true)
    String     fromAddressPassword;

    @ApiModelProperty(value = "收款方", required = true)
    String     toAddress;

    @ApiModelProperty(value = "金额", required = true)
    BigDecimal value;

    @ApiModelProperty(value = "交易序号")
    BigInteger nonce;

    @ApiModelProperty("gas 价格")
    BigInteger gasPrice;

    @ApiModelProperty("gas 数量")
    BigInteger gasLimit;
}
