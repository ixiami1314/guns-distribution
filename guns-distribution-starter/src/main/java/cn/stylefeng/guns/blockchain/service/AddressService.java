package cn.stylefeng.guns.blockchain.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;

import java.util.List;

/**
 * Project Name  guns-distribution
 * File Name     AddressService
 * Package Name  cn.stylefeng.guns.blockchain.service
 * Date          2021/11/19 - 10:38 下午
 * Project Desc
 * Copyright (c) 2021, baiyuetong.cn Corp. All Rights Reserved.
 *
 * @author weijun
 */

@Service
@Slf4j
public class AddressService {

    @Autowired
    Web3j web3j;

    public List<String> listAll () {
        try {
            return web3j.ethAccounts().send().getAccounts();
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("出现错误 {}", ex.getLocalizedMessage());
        }
        return null;
    }
}
