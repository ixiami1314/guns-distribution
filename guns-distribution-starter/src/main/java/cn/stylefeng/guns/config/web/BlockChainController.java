package cn.stylefeng.guns.config.web;

import cn.stylefeng.guns.config.blockchain.Web3jService;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.Executable;

/**
 * Project Name  guns-distribution
 * File Name     BlockChainController
 * Package Name  cn.stylefeng.guns.config.web
 * Date          2021/11/18 2:15 下午
 * Project Desc   
 * Copyright (c) 2021, Baiyuetong Corp. All Rights Reserved.
 * @author weijun
 */

@Api(tags = "区块链相关")
@RestController
@RequestMapping("/v2/api-docs/blockchain")
public class BlockChainController {

    @Autowired
    Web3jService web3jService;

    @ApiOperation("帐户 查询余额")
    @GetMapping("balance/{address}")
    ResponseData getBalance (@PathVariable("address") String address) throws IOException {
        return ResponseData.success(web3jService.getETHBalance(address));
    }

    @ApiOperation("帐户 获取nonce")
    @GetMapping("nonce/{address}")
    ResponseData getNonce (@PathVariable("address") String address) throws IOException {
        return ResponseData.success(web3jService.getNonce(address));
    }
}
