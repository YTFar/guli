package com.guli.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.api.GuliOrderControllrtApi;
import com.guli.mapper.GuliOrderMapper;
import com.guli.pojo.GuliCourse;
import com.guli.pojo.GuliOrder;
import com.guli.pojo.response.AllTypePage;
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
public class GuliOrderController implements GuliOrderControllrtApi {

    @Autowired
    GuliOrderMapper guliOrderMapper;

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
    @Override
    @GetMapping("/findAllPageOrdel")
    public AllTypePage<OrderAndUser> findAllPageOrdel(@RequestParam("pageNo") int pageNo,
                                                      @RequestParam("pageSize") int pageSize,
                                                      @RequestParam("userId") int userId,
                                                      @RequestParam("orderNumber") String orderNumber,
                                                      @RequestParam("userName")String userName) {
//        List<OrderAndUser> allOrdel = guliOrderMapper.findAllOrdel(userId);
//        System.out.println(allOrdel);
        if(orderNumber.equals("*"))
            orderNumber = "";
        if(userName.equals("*"))
            userName = "";
        Page<OrderAndUser> page = new Page<>(pageNo,pageSize);
        page.setRecords(guliOrderService.findAllPageOrdel(page,userId,orderNumber,userName));
        AllTypePage<OrderAndUser> allTypePage = new AllTypePage<OrderAndUser>();
        //写自己传入的页码
        allTypePage.setPageNo(pageNo);
        //写入自己的显示数据量
        allTypePage.setPageSize(pageSize);
        //调用查询出分页对象的总页数
        allTypePage.setPageTotal((int)page.getTotal());
        //调用查询出分页对象当前显示数据
        allTypePage.setPageList(page.getRecords());
        return allTypePage;
    }

    @Override
    public int updateOrder(GuliOrder guliOrder) {
        return guliOrderService.updateOrder(guliOrder);
    }
}
