package com.guli.service;

import com.guli.pojo.GuliOrder;
import com.guli.pojo.ordervo.OrderAndUser;
import com.guli.pojo.response.AllTypePage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 齐天大圣
 * @date 2019/9/7 15:31
 * @package com.guli.service
 */
@FeignClient(value = "GULI-PROVIDER-PRODUCT")
public interface GuliOrderService {

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
    public AllTypePage<OrderAndUser> findAllPageOrdel(@RequestParam("pageNo") int pageNo,
                                                      @RequestParam("pageSize") int pageSize,
                                                      @RequestParam("userId") Long userId,
                                                      @RequestParam("orderNumber") String orderNumber,
                                                      @RequestParam("userName")String userName,
                                                      @RequestParam("orderStatus") int orderStatus);

    /**
     * 修改订单
     * @param guliOrder 订单信息
     * @return
     */
    @PutMapping("/updateOrder")
    public int updateOrder(@RequestBody GuliOrder guliOrder);

    /**
     * 按订单id查询订单信息
     * @param orderId
     * @return
     */
    @GetMapping("/guliOrder/findOneOrder")
    public OrderAndUser findOneOrder(@RequestParam("orderId") int orderId);
}
