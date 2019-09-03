package com.guli.pojo;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.extension.activerecord.Model;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.time.LocalDateTime;
    import java.io.Serializable;

/**
* <p>
    * ??ȡ?Żݱ
    * </p>
*
* @author slz
* @since 2019-09-03
*/
    public class GuliReceive extends Model<GuliReceive> {

    private static final long serialVersionUID = 1L;

            @TableId(value = "receive_id", type = IdType.AUTO)
    private Long receiveId;

    private Long discountId;

    private Long userId;

    private LocalDateTime receiveCreateTime;

    private Integer receiveStatus;

        public Long getReceiveId() {
        return receiveId;
        }

            public void setReceiveId(Long receiveId) {
        this.receiveId = receiveId;
        }
        public Long getDiscountId() {
        return discountId;
        }

            public void setDiscountId(Long discountId) {
        this.discountId = discountId;
        }
        public Long getUserId() {
        return userId;
        }

            public void setUserId(Long userId) {
        this.userId = userId;
        }
        public LocalDateTime getReceiveCreateTime() {
        return receiveCreateTime;
        }

            public void setReceiveCreateTime(LocalDateTime receiveCreateTime) {
        this.receiveCreateTime = receiveCreateTime;
        }
        public Integer getReceiveStatus() {
        return receiveStatus;
        }

            public void setReceiveStatus(Integer receiveStatus) {
        this.receiveStatus = receiveStatus;
        }

    @Override
    protected Serializable pkVal() {
        return this.receiveId;
    }

    @Override
    public String toString() {
    return "GuliReceive{" +
            "receiveId=" + receiveId +
            ", discountId=" + discountId +
            ", userId=" + userId +
            ", receiveCreateTime=" + receiveCreateTime +
            ", receiveStatus=" + receiveStatus +
    "}";
    }
}
