package com.guli.pojo.ordervo;

import com.guli.pojo.GuliOrder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
public class GuliOrderAndCourseVo {

    private int userId;

    private Long orderId;

    private String courseName;

    private String orderNumber;

    private BigDecimal orderPrice;

    private LocalDateTime orderCreateTime;

    private String orderStatusStr;

    private Integer orderStatus;

    private LocalDateTime orderUpdateTime;

    public String getOrderStatusStr() {
        this.orderStatusStr = orderStatus == 0 ? "未付款" : orderStatus == 1 ? "已付款":orderStatus==2 ? "交易关闭":" 退款";
        return orderStatusStr;
    }
}
