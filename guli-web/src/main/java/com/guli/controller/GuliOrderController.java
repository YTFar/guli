package com.guli.controller;


import com.guli.message.response.CommonCode;
import com.guli.pojo.GuliOrder;
import com.guli.pojo.GuliPower;
import com.guli.response.ObjectResult;
import com.guli.service.GuliOrderService;
import com.guli.service.GuliPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    GuliPowerService guliPowerService;

    /**
     * 按教师id分页查询订单信息
     * @param pageNo 当前页
     * @param pageSize 数据量
     * @param userId 教师id
     * @param orderNumber 订单号
     * @param userName 收货人(模糊查询)
     * @return
     */
    @GetMapping("/findAllPageOrdel")
    public ObjectResult findAllPageOrdel(@RequestParam("pageNo") int pageNo,
                                         @RequestParam("pageSize") int pageSize,
                                         @RequestParam("userId") Long userId,
                                         @RequestParam("orderNumber") String orderNumber,
                                         @RequestParam("userName")String userName,
                                         @RequestParam("orderStatus") int orderStatus){
        GuliPower userIdPower = guliPowerService.findUserIdPower(userId);
        if(userIdPower.getPowerName().equals("管理员")){
            userId = -1l;
        }
        if(orderNumber.equals(""))
            orderNumber = "*";
        if(userName.equals(""))
            userName = "*";
        return new ObjectResult(CommonCode.SUCCESS,guliOrderService.findAllPageOrdel(pageNo,pageSize,userId,orderNumber,userName,orderStatus));
    }

    /**
     * 修改订单
     * @param guliOrder 订单信息
     * @return
     */
    @PutMapping("/updateOrder")
    public ObjectResult updateOrder(@RequestBody GuliOrder guliOrder){
        int order = guliOrderService.updateOrder(guliOrder);
        if(order < 1){
            return new ObjectResult(CommonCode.SUCCESS,"修改失败");
        }
        return new ObjectResult(CommonCode.SUCCESS,"修改成功");
    }

    /**
     * 按订单id查询订单信息
     * @param orderId
     * @return
     */
    @GetMapping("/findOneOrder")
    public ObjectResult findOneOrder(@RequestParam("orderId") int orderId){
        return new ObjectResult(CommonCode.SUCCESS,guliOrderService.findOneOrder(orderId));
    }

}
