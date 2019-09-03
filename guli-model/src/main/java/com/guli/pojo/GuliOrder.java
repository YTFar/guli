package com.guli.pojo;

    import java.math.BigDecimal;
    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.extension.activerecord.Model;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.time.LocalDateTime;
    import java.io.Serializable;

/**
* <p>
    * ?????
    * </p>
*
* @author slz
* @since 2019-09-03
*/
    public class GuliOrder extends Model<GuliOrder> {

    private static final long serialVersionUID = 1L;

            @TableId(value = "order_id", type = IdType.AUTO)
    private Long orderId;

    private Long itemId;

    private String orderNumber;

    private BigDecimal orderPrice;

    private Integer orderStatus;

    private BigDecimal orderDiscount;

    private LocalDateTime orderCreateTime;

    private String orderTradeName;

    private BigDecimal orderTradePrice;

            /**
            * no 0 yes 1
            */
    private Integer orderValidity;

            /**
            * 当订单状态不为0或1时该列不能为空
            
            */
    private LocalDateTime orderUpdateTime;

        public Long getOrderId() {
        return orderId;
        }

            public void setOrderId(Long orderId) {
        this.orderId = orderId;
        }
        public Long getItemId() {
        return itemId;
        }

            public void setItemId(Long itemId) {
        this.itemId = itemId;
        }
        public String getOrderNumber() {
        return orderNumber;
        }

            public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
        }
        public BigDecimal getOrderPrice() {
        return orderPrice;
        }

            public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
        }
        public Integer getOrderStatus() {
        return orderStatus;
        }

            public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
        }
        public BigDecimal getOrderDiscount() {
        return orderDiscount;
        }

            public void setOrderDiscount(BigDecimal orderDiscount) {
        this.orderDiscount = orderDiscount;
        }
        public LocalDateTime getOrderCreateTime() {
        return orderCreateTime;
        }

            public void setOrderCreateTime(LocalDateTime orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
        }
        public String getOrderTradeName() {
        return orderTradeName;
        }

            public void setOrderTradeName(String orderTradeName) {
        this.orderTradeName = orderTradeName;
        }
        public BigDecimal getOrderTradePrice() {
        return orderTradePrice;
        }

            public void setOrderTradePrice(BigDecimal orderTradePrice) {
        this.orderTradePrice = orderTradePrice;
        }
        public Integer getOrderValidity() {
        return orderValidity;
        }

            public void setOrderValidity(Integer orderValidity) {
        this.orderValidity = orderValidity;
        }
        public LocalDateTime getOrderUpdateTime() {
        return orderUpdateTime;
        }

            public void setOrderUpdateTime(LocalDateTime orderUpdateTime) {
        this.orderUpdateTime = orderUpdateTime;
        }

    @Override
    protected Serializable pkVal() {
        return this.orderId;
    }

    @Override
    public String toString() {
    return "GuliOrder{" +
            "orderId=" + orderId +
            ", itemId=" + itemId +
            ", orderNumber=" + orderNumber +
            ", orderPrice=" + orderPrice +
            ", orderStatus=" + orderStatus +
            ", orderDiscount=" + orderDiscount +
            ", orderCreateTime=" + orderCreateTime +
            ", orderTradeName=" + orderTradeName +
            ", orderTradePrice=" + orderTradePrice +
            ", orderValidity=" + orderValidity +
            ", orderUpdateTime=" + orderUpdateTime +
    "}";
    }
}
