package cn.stylefeng.guns.blockchain.api;

import cn.stylefeng.guns.blockchain.param.TransferParam;
import cn.stylefeng.guns.blockchain.service.BlockChainService;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Project Name  guns-distribution
 * File Name     WalletController
 * Package Name  cn.stylefeng.guns.blockchain.api
 * Date          2021/11/18 4:52 下午
 * Project Desc  钱包api
 * Copyright (c) 2021, Baiyuetong Corp. All Rights Reserved.
 * @author weijun
 */
@Api(tags = "区块链相关")
@RestController
@RequestMapping("/blockchain/wallet")
public class WalletController {

    @Autowired
    BlockChainService blockChainService;

    @ApiOperation("帐户 查询余额")
    @GetMapping("{address}/balance")
    ResponseData getETHBalance (@PathVariable("address") String address) throws IOException {
        return ResponseData.success(blockChainService.getETHBalance(address));
    }

    @ApiOperation("交易 转帐")
    @PostMapping("/transfer")
    ResponseData transfer (@RequestBody TransferParam param) throws IOException {
        return ResponseData.success(blockChainService.sendTransaction(param));
    }
}
