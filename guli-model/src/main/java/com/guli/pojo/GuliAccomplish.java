package com.guli.pojo;

    import java.math.BigDecimal;
    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.extension.activerecord.Model;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * Ŀ¼???ɱ
    * </p>
*
* @author slz
* @since 2019-09-03
*/
    public class GuliAccomplish extends Model<GuliAccomplish> {

    private static final long serialVersionUID = 1L;

            @TableId(value = "accomplish_id", type = IdType.AUTO)
    private Long accomplishId;

    private Long catalogueId;

    private Long userId;

            /**
            * 学习了 0  完成了 1 加入学习 2
            */
    private Integer accomplishLearningTrogress;

    private BigDecimal accomplishLearningTime;

    private String userName;

    private String catalogueName;

        public Long getAccomplishId() {
        return accomplishId;
        }

            public void setAccomplishId(Long accomplishId) {
        this.accomplishId = accomplishId;
        }
        public Long getCatalogueId() {
        return catalogueId;
        }

            public void setCatalogueId(Long catalogueId) {
        this.catalogueId = catalogueId;
        }
        public Long getUserId() {
        return userId;
        }

            public void setUserId(Long userId) {
        this.userId = userId;
        }
        public Integer getAccomplishLearningTrogress() {
        return accomplishLearningTrogress;
        }

            public void setAccomplishLearningTrogress(Integer accomplishLearningTrogress) {
        this.accomplishLearningTrogress = accomplishLearningTrogress;
        }
        public BigDecimal getAccomplishLearningTime() {
        return accomplishLearningTime;
        }

            public void setAccomplishLearningTime(BigDecimal accomplishLearningTime) {
        this.accomplishLearningTime = accomplishLearningTime;
        }
        public String getUserName() {
        return userName;
        }

            public void setUserName(String userName) {
        this.userName = userName;
        }
        public String getCatalogueName() {
        return catalogueName;
        }

            public void setCatalogueName(String catalogueName) {
        this.catalogueName = catalogueName;
        }

    @Override
    protected Serializable pkVal() {
        return this.accomplishId;
    }

    @Override
    public String toString() {
    return "GuliAccomplish{" +
            "accomplishId=" + accomplishId +
            ", catalogueId=" + catalogueId +
            ", userId=" + userId +
            ", accomplishLearningTrogress=" + accomplishLearningTrogress +
            ", accomplishLearningTime=" + accomplishLearningTime +
            ", userName=" + userName +
            ", catalogueName=" + catalogueName +
    "}";
    }
}
