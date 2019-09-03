package com.guli.pojo;

    import java.math.BigDecimal;
    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.extension.activerecord.Model;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.time.LocalDateTime;
    import java.io.Serializable;

/**
* <p>
    * ?γ̱
    * </p>
*
* @author slz
* @since 2019-09-03
*/
    public class GuliCourse extends Model<GuliCourse> {

    private static final long serialVersionUID = 1L;

            @TableId(value = "course_id", type = IdType.AUTO)
    private Long courseId;

    private Long classifyId;

    private Long itemId;

    private String courseName;

    private String courseBrief;

    private String courseImage;

    private BigDecimal coursePrice;

    private String courseValidity;

    private LocalDateTime courseCreateTime;

    private Long courseWatched;

        public Long getCourseId() {
        return courseId;
        }

            public void setCourseId(Long courseId) {
        this.courseId = courseId;
        }
        public Long getClassifyId() {
        return classifyId;
        }

            public void setClassifyId(Long classifyId) {
        this.classifyId = classifyId;
        }
        public Long getItemId() {
        return itemId;
        }

            public void setItemId(Long itemId) {
        this.itemId = itemId;
        }
        public String getCourseName() {
        return courseName;
        }

            public void setCourseName(String courseName) {
        this.courseName = courseName;
        }
        public String getCourseBrief() {
        return courseBrief;
        }

            public void setCourseBrief(String courseBrief) {
        this.courseBrief = courseBrief;
        }
        public String getCourseImage() {
        return courseImage;
        }

            public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
        }
        public BigDecimal getCoursePrice() {
        return coursePrice;
        }

            public void setCoursePrice(BigDecimal coursePrice) {
        this.coursePrice = coursePrice;
        }
        public String getCourseValidity() {
        return courseValidity;
        }

            public void setCourseValidity(String courseValidity) {
        this.courseValidity = courseValidity;
        }
        public LocalDateTime getCourseCreateTime() {
        return courseCreateTime;
        }

            public void setCourseCreateTime(LocalDateTime courseCreateTime) {
        this.courseCreateTime = courseCreateTime;
        }
        public Long getCourseWatched() {
        return courseWatched;
        }

            public void setCourseWatched(Long courseWatched) {
        this.courseWatched = courseWatched;
        }

    @Override
    protected Serializable pkVal() {
        return this.courseId;
    }

    @Override
    public String toString() {
    return "GuliCourse{" +
            "courseId=" + courseId +
            ", classifyId=" + classifyId +
            ", itemId=" + itemId +
            ", courseName=" + courseName +
            ", courseBrief=" + courseBrief +
            ", courseImage=" + courseImage +
            ", coursePrice=" + coursePrice +
            ", courseValidity=" + courseValidity +
            ", courseCreateTime=" + courseCreateTime +
            ", courseWatched=" + courseWatched +
    "}";
    }
}
