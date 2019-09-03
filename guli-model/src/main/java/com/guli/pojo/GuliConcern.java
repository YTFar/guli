package com.guli.pojo;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.extension.activerecord.Model;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * ??˿?
    * </p>
*
* @author slz
* @since 2019-09-03
*/
    public class GuliConcern extends Model<GuliConcern> {

    private static final long serialVersionUID = 1L;

            @TableId(value = "concern_id", type = IdType.AUTO)
    private Long concernId;

    private Long userId;

    private Long fansId;

        public Long getConcernId() {
        return concernId;
        }

            public void setConcernId(Long concernId) {
        this.concernId = concernId;
        }
        public Long getUserId() {
        return userId;
        }

            public void setUserId(Long userId) {
        this.userId = userId;
        }
        public Long getFansId() {
        return fansId;
        }

            public void setFansId(Long fansId) {
        this.fansId = fansId;
        }

    @Override
    protected Serializable pkVal() {
        return this.concernId;
    }

    @Override
    public String toString() {
    return "GuliConcern{" +
            "concernId=" + concernId +
            ", userId=" + userId +
            ", fansId=" + fansId +
    "}";
    }
}
