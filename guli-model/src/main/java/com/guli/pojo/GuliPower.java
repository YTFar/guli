package com.guli.pojo;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.extension.activerecord.Model;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * ?û?Ȩ?
    * </p>
*
* @author slz
* @since 2019-09-03
*/
    public class GuliPower extends Model<GuliPower> {

    private static final long serialVersionUID = 1L;

            @TableId(value = "power_id", type = IdType.AUTO)
    private Long powerId;

    private Long userId;

    private String powerName;

        public Long getPowerId() {
        return powerId;
        }

            public void setPowerId(Long powerId) {
        this.powerId = powerId;
        }
        public Long getUserId() {
        return userId;
        }

            public void setUserId(Long userId) {
        this.userId = userId;
        }
        public String getPowerName() {
        return powerName;
        }

            public void setPowerName(String powerName) {
        this.powerName = powerName;
        }

    @Override
    protected Serializable pkVal() {
        return this.powerId;
    }

    @Override
    public String toString() {
    return "GuliPower{" +
            "powerId=" + powerId +
            ", userId=" + userId +
            ", powerName=" + powerName +
    "}";
    }
}
