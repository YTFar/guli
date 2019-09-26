package com.guli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guli.mapper.GuliOrderMapper;
import com.guli.pojo.GuliOrder;
import com.guli.pojo.ordervo.OrderAndUser;
import com.guli.service.GuliOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * ????? 服务实现类
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@Service
public class GuliOrderServiceImpl extends ServiceImpl<GuliOrderMapper, GuliOrder> implements GuliOrderService {

    @Override
    public List<OrderAndUser> findAllPageOrdel(Page<OrderAndUser> page, Long userId, String orderNumber, String userName, int orderStatus) {
        return this.baseMapper.findAllPageOrdel(page,userId,orderNumber,userName,orderStatus);
    }

    @Override
    @Transactional
    public int updateOrder(GuliOrder guliOrder) {
        GuliOrder order_id = this.baseMapper.selectOne(new QueryWrapper<GuliOrder>().eq("order_id", guliOrder.getOrderId()));
        if(guliOrder.getOrderNumber()!=null)
            order_id.setOrderNumber(guliOrder.getOrderNumber());
        if(guliOrder.getOrderPrice()!=null)
            order_id.setOrderPrice(guliOrder.getOrderPrice());
        if(guliOrder.getOrderDiscount()!=null)
            order_id.setOrderDiscount(guliOrder.getOrderDiscount());
        if (guliOrder.getOrderTradeName()!=null)
            order_id.setOrderTradeName(guliOrder.getOrderTradeName());
        if(guliOrder.getOrderTradePrice()!=null)
            order_id.setOrderTradePrice(guliOrder.getOrderTradePrice());
        if(guliOrder.getOrderValidity()!=null)
            order_id.setOrderValidity(guliOrder.getOrderValidity());
        return this.baseMapper.updateById(order_id);
    }

    @Override
    public OrderAndUser findOneOrder(int orderId) {
        return this.baseMapper.findOneOrder(orderId);
    }


}
