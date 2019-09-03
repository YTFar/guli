package com.guli.pojo;

    import java.math.BigDecimal;
    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.extension.activerecord.Model;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * ?????
    * </p>
*
* @author slz
* @since 2019-09-03
*/
    public class GuliTopic extends Model<GuliTopic> {

    private static final long serialVersionUID = 1L;

            @TableId(value = "topic_id", type = IdType.AUTO)
    private Long topicId;

    private Long courseId;

    private Long catalogueId;

    private Long sponsorId;

    private Long replyId;

    private String topicName;

    private String topicContent;

    private Long topicBrowse;

    private BigDecimal topicCreateTime;

    private BigDecimal topicReplyTime;

            /**
            * 0 问答 1 话题
            */
    private Integer topicType;

        public Long getTopicId() {
        return topicId;
        }

            public void setTopicId(Long topicId) {
        this.topicId = topicId;
        }
        public Long getCourseId() {
        return courseId;
        }

            public void setCourseId(Long courseId) {
        this.courseId = courseId;
        }
        public Long getCatalogueId() {
        return catalogueId;
        }

            public void setCatalogueId(Long catalogueId) {
        this.catalogueId = catalogueId;
        }
        public Long getSponsorId() {
        return sponsorId;
        }

            public void setSponsorId(Long sponsorId) {
        this.sponsorId = sponsorId;
        }
        public Long getReplyId() {
        return replyId;
        }

            public void setReplyId(Long replyId) {
        this.replyId = replyId;
        }
        public String getTopicName() {
        return topicName;
        }

            public void setTopicName(String topicName) {
        this.topicName = topicName;
        }
        public String getTopicContent() {
        return topicContent;
        }

            public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
        }
        public Long getTopicBrowse() {
        return topicBrowse;
        }

            public void setTopicBrowse(Long topicBrowse) {
        this.topicBrowse = topicBrowse;
        }
        public BigDecimal getTopicCreateTime() {
        return topicCreateTime;
        }

            public void setTopicCreateTime(BigDecimal topicCreateTime) {
        this.topicCreateTime = topicCreateTime;
        }
        public BigDecimal getTopicReplyTime() {
        return topicReplyTime;
        }

            public void setTopicReplyTime(BigDecimal topicReplyTime) {
        this.topicReplyTime = topicReplyTime;
        }
        public Integer getTopicType() {
        return topicType;
        }

            public void setTopicType(Integer topicType) {
        this.topicType = topicType;
        }

    @Override
    protected Serializable pkVal() {
        return this.topicId;
    }

    @Override
    public String toString() {
    return "GuliTopic{" +
            "topicId=" + topicId +
            ", courseId=" + courseId +
            ", catalogueId=" + catalogueId +
            ", sponsorId=" + sponsorId +
            ", replyId=" + replyId +
            ", topicName=" + topicName +
            ", topicContent=" + topicContent +
            ", topicBrowse=" + topicBrowse +
            ", topicCreateTime=" + topicCreateTime +
            ", topicReplyTime=" + topicReplyTime +
            ", topicType=" + topicType +
    "}";
    }
}
