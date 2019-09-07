package com.guli.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guli.api.GuliOrderControllrtApi;
import com.guli.mapper.GuliOrderMapper;
import com.guli.pojo.OrderVo.GuliOrderAndUser;
import com.guli.service.impl.GuliClassifyServiceImpl;
import com.guli.service.impl.GuliOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * ????? 前端控制器
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@RestController
@RequestMapping("/guliOrder")
public class GuliOrderController implements GuliOrderControllrtApi {

    @Autowired
    GuliOrderMapper guliOrderMapper;

    /**
     * 按用户id查询所有课程的订单
     * @param userId
     * @return
     */
    @Override
    @GetMapping("/orderAll")
    public List<GuliOrderAndUser> findAllOrdel(@RequestParam("id") int userId) {
        List<GuliOrderAndUser> allOrdel = guliOrderMapper.findAllOrdel(userId);
        System.out.println(allOrdel);
        return allOrdel;
    }
}
