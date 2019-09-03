package com.guli.pojo;

    import java.math.BigDecimal;
    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.extension.activerecord.Model;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * ???۱
    * </p>
*
* @author slz
* @since 2019-09-03
*/
    public class GuliEvaluate extends Model<GuliEvaluate> {

    private static final long serialVersionUID = 1L;

            @TableId(value = "evaluate_id", type = IdType.AUTO)
    private Long evaluateId;

    private Long itemId;

    private String evaluateContent;

            /**
            * 星评1~5
            */
    private Integer evaluateRating;

    private BigDecimal evaluateCreateTime;

        public Long getEvaluateId() {
        return evaluateId;
        }

            public void setEvaluateId(Long evaluateId) {
        this.evaluateId = evaluateId;
        }
        public Long getItemId() {
        return itemId;
        }

            public void setItemId(Long itemId) {
        this.itemId = itemId;
        }
        public String getEvaluateContent() {
        return evaluateContent;
        }

            public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
        }
        public Integer getEvaluateRating() {
        return evaluateRating;
        }

            public void setEvaluateRating(Integer evaluateRating) {
        this.evaluateRating = evaluateRating;
        }
        public BigDecimal getEvaluateCreateTime() {
        return evaluateCreateTime;
        }

            public void setEvaluateCreateTime(BigDecimal evaluateCreateTime) {
        this.evaluateCreateTime = evaluateCreateTime;
        }

    @Override
    protected Serializable pkVal() {
        return this.evaluateId;
    }

    @Override
    public String toString() {
    return "GuliEvaluate{" +
            "evaluateId=" + evaluateId +
            ", itemId=" + itemId +
            ", evaluateContent=" + evaluateContent +
            ", evaluateRating=" + evaluateRating +
            ", evaluateCreateTime=" + evaluateCreateTime +
    "}";
    }
}
