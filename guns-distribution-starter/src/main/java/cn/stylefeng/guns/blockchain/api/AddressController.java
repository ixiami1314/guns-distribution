package cn.stylefeng.guns.blockchain.api;

import cn.stylefeng.guns.blockchain.service.AddressService;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project Name  guns-distribution
 * File Name     AddressController
 * Package Name  cn.stylefeng.guns.blockchain.api
 * Date          2021/11/19 - 10:46 下午
 * Project Desc
 * Copyright (c) 2021, baiyuetong.cn Corp. All Rights Reserved.
 *
 * @author weijun
 */

@Api(tags = "区块链相关")
@RestController
@RequestMapping("/blockchain/address/")
public class AddressController {

    @Autowired
    AddressService addressService;

    @ApiOperation("地址 列表所有")
    @GetMapping("list")
    ResponseData list () {
        return ResponseData.success(addressService.listAll());
    }
}
