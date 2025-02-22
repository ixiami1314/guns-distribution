package cn.stylefeng.guns.blockchain.api;

import cn.stylefeng.guns.blockchain.contract.MyGasProvider;
import cn.stylefeng.guns.blockchain.contract.Ownable;
import cn.stylefeng.guns.blockchain.properties.BlockChainProperties;
import cn.stylefeng.guns.blockchain.service.ContractService;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.TransactionManager;

/**
 * Project Name  guns-distribution
 * File Name     ContractController
 * Package Name  cn.stylefeng.guns.blockchain.api
 * Date          2021/11/18 7:43 下午
 * Project Desc  智能合约接口 
 * Copyright (c) 2021, Baiyuetong Corp. All Rights Reserved.
 * @author weijun
 */
@Api(tags = "区块链相关")
@RestController
@RequestMapping("/blockchain/contract")
public class ContractController {

    @Autowired
    ContractService contractService;

    @ApiOperation("智能合约 部署（Panama）")
    @PostMapping("panama/deploy")
    ResponseData deployPanama () {
        contractService.deployPanama();
        return ResponseData.success();
    }

    @ApiOperation("智能合约 部署（Ownable）")
    @PostMapping("ownable/deploy")
    ResponseData deployOwnable () {
        contractService.deployOwnable();
        return ResponseData.success();
    }

    @ApiOperation("智能合约 Ownable 调用功能")
    @PostMapping("ownable/transfer/{address}")
    ResponseData deployOwnable (@PathVariable("address") String toAddress) {
        return ResponseData.success(contractService.transferOwnerShip(toAddress));
    }

    @ApiOperation("智能合约 Ownable 授权")
    @PostMapping("ownable/approve/{address}")
    ResponseData approve (@PathVariable("address") String toAddress) {
        return ResponseData.success(contractService.transferAporove(toAddress));
    }
}
