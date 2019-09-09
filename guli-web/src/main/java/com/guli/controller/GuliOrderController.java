package com.guli.controller;


import com.guli.pojo.GuliOrder;
import com.guli.pojo.OrderVo.GuliOrderAndUser;
import com.guli.service.GuliOrderService;
import com.guli.service.GuliUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
public class GuliOrderController {

    @Autowired
    GuliOrderService guliOrderService;

    //按教师id查询自己课程全部订单
    @GetMapping("/orderAll")
    public List<GuliOrderAndUser> findAll(@RequestParam("id") int userId){
//        return null;
        return guliOrderService.findAllOrdel(userId);
    }

}
