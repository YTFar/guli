package com.guli.controller;


import com.guli.message.response.CommonCode;
import com.guli.pojo.response.AllTypePage;
import com.guli.response.ObjectResult;
import com.guli.service.GuliOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.guli.pojo.OrderVo.OrderAndUser;

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

    /**
     * 按教师id分页查询订单信息
     * @param pageNo 当前页
     * @param pageSize 数据量
     * @param userId 教师id
     * @param orderNumber 订单号
     * @param userName 收货人(模糊查询)
     * @return
     */
    @GetMapping("/guliOrder/findAllPageOrdel")
    public ObjectResult findAllPageOrdel(@RequestParam("pageNo") int pageNo,
                                         @RequestParam("pageSize") int pageSize,
                                         @RequestParam("userId") int userId,
                                         @RequestParam("orderNumber") String orderNumber,
                                         @RequestParam("userName")String userName){
        return new ObjectResult(CommonCode.SUCCESS,guliOrderService.findAllPageOrdel(pageNo,pageSize,userId,orderNumber,userName));
    }

}
