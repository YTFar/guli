package com.guli.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.pojo.GuliOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guli.pojo.OrderVo.OrderAndUser;

import java.util.List;

/**
 * <p>
 * ????? 服务类
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
public interface GuliOrderService extends IService<GuliOrder> {

    List<OrderAndUser> findAllPageOrdel(Page<OrderAndUser> page, int userId, String orderNumber, String userName);

    int updateOrder(GuliOrder guliOrder);
}
