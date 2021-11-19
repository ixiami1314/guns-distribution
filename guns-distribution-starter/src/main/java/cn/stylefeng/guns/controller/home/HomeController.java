package cn.stylefeng.guns.controller.home;

import cn.stylefeng.guns.modular.distribution.service.DistAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Project Name  guns-distribution
 * File Name     HomeController
 * Package Name  cn.stylefeng.guns.controller
 * Date          2021/11/20 - 12:20 上午
 * Project Desc
 * Copyright (c) 2021, baiyuetong.cn Corp. All Rights Reserved.
 *
 * @author weijun
 */
@Controller
@RequestMapping("/blockchain/home")
public class HomeController {
    final String PREFIX = "/modular/home";

    /**
     * 跳转到主页面
     */
    @RequestMapping("connect")
    public ModelAndView connect(ModelAndView mav) {
        mav.addObject("webAddress", "https://i.suzhouzhangyixin.com");
        mav.setViewName(PREFIX + "/connect.html");
        return mav;
//        return PREFIX + "/connect.html";
    }

}
