package com.guli.service;

import com.guli.pojo.GuliOrder;
import com.guli.pojo.OrderVo.GuliOrderAndUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 齐天大圣
 * @date 2019/9/7 15:31
 * @package com.guli.service
 */
@FeignClient(value = "GULI-PROVIDER-PRODUCT")
public interface GuliOrderService {

    /**
     * 按用户id查询所有课程的订单
     * @param id
     * @return
     */
    @GetMapping("/guliOrder/orderAll")
    public List<GuliOrderAndUser> findAllOrdel(@RequestParam("id") int id);
}
