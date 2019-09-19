package com.guli.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guli.api.GuliPowerControllerApi;
import com.guli.mapper.GuliPowerMapper;
import com.guli.pojo.GuliPower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * ?û?Ȩ? 前端控制器
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@RestController
@RequestMapping("/guliPower")
public class GuliPowerController implements GuliPowerControllerApi {

    @Autowired
    GuliPowerMapper guliPowerMapper;

    /**
     * 查询权限
     * @param userId
     * @return 权限信息
     */
    @Override
    @GetMapping("/findUserIdPower")
    public GuliPower findUserIdPower(@RequestParam("userId") Long userId) {
        return guliPowerMapper.selectOne(new QueryWrapper<GuliPower>().eq("user_id",userId));
    }
}
