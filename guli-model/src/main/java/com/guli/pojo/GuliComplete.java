package com.guli.pojo;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.extension.activerecord.Model;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * ???ɱ
    * </p>
*
* @author slz
* @since 2019-09-03
*/
    public class GuliComplete extends Model<GuliComplete> {

    private static final long serialVersionUID = 1L;

            @TableId(value = "complete_id", type = IdType.AUTO)
    private Integer completeId;

    private Long userId;

    private Long catalogueId;

    private Integer completeNumber;

        public Integer getCompleteId() {
        return completeId;
        }

            public void setCompleteId(Integer completeId) {
        this.completeId = completeId;
        }
        public Long getUserId() {
        return userId;
        }

            public void setUserId(Long userId) {
        this.userId = userId;
        }
        public Long getCatalogueId() {
        return catalogueId;
        }

            public void setCatalogueId(Long catalogueId) {
        this.catalogueId = catalogueId;
        }
        public Integer getCompleteNumber() {
        return completeNumber;
        }

            public void setCompleteNumber(Integer completeNumber) {
        this.completeNumber = completeNumber;
        }

    @Override
    protected Serializable pkVal() {
        return this.completeId;
    }

    @Override
    public String toString() {
    return "GuliComplete{" +
            "completeId=" + completeId +
            ", userId=" + userId +
            ", catalogueId=" + catalogueId +
            ", completeNumber=" + completeNumber +
    "}";
    }
}
