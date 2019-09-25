package com.guli.pojo.ordervo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GuliDiscountVo {

    private Long receiveId;

    private Long discountId;

    private Long userId;

    private LocalDateTime receiveCreateTime;

    private Integer receiveStatus;

    private Integer discountName;

    private Integer discountPrice;

    private LocalDateTime discontEndTime;
}
