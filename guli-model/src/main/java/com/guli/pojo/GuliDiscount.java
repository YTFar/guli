package com.guli.pojo;

    import java.math.BigDecimal;
    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.extension.activerecord.Model;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.time.LocalDateTime;
    import java.io.Serializable;

/**
* <p>
    * ?Żݱ
    * </p>
*
* @author slz
* @since 2019-09-03
*/
    public class GuliDiscount extends Model<GuliDiscount> {

    private static final long serialVersionUID = 1L;

            @TableId(value = "discount_id", type = IdType.AUTO)
    private Long discountId;

    private Integer discountName;

    private Integer discountPrice;

    private BigDecimal discountCreateTime;

    private LocalDateTime discontEndTime;

        public Long getDiscountId() {
        return discountId;
        }

            public void setDiscountId(Long discountId) {
        this.discountId = discountId;
        }
        public Integer getDiscountName() {
        return discountName;
        }

            public void setDiscountName(Integer discountName) {
        this.discountName = discountName;
        }
        public Integer getDiscountPrice() {
        return discountPrice;
        }

            public void setDiscountPrice(Integer discountPrice) {
        this.discountPrice = discountPrice;
        }
        public BigDecimal getDiscountCreateTime() {
        return discountCreateTime;
        }

            public void setDiscountCreateTime(BigDecimal discountCreateTime) {
        this.discountCreateTime = discountCreateTime;
        }
        public LocalDateTime getDiscontEndTime() {
        return discontEndTime;
        }

            public void setDiscontEndTime(LocalDateTime discontEndTime) {
        this.discontEndTime = discontEndTime;
        }

    @Override
    protected Serializable pkVal() {
        return this.discountId;
    }

    @Override
    public String toString() {
    return "GuliDiscount{" +
            "discountId=" + discountId +
            ", discountName=" + discountName +
            ", discountPrice=" + discountPrice +
            ", discountCreateTime=" + discountCreateTime +
            ", discontEndTime=" + discontEndTime +
    "}";
    }
}
