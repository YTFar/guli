package com.guli.pojo;

    import java.math.BigDecimal;
    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.extension.activerecord.Model;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * ??
    * </p>
*
* @author slz
* @since 2019-09-03
*/
    public class GuliActivitie extends Model<GuliActivitie> {

    private static final long serialVersionUID = 1L;

            @TableId(value = "activitie_id", type = IdType.AUTO)
    private Long activitieId;

    private Long courseId;

    private String activitieType;

    private BigDecimal activitieNumber;

    private String activitieEndTime;

        public Long getActivitieId() {
        return activitieId;
        }

            public void setActivitieId(Long activitieId) {
        this.activitieId = activitieId;
        }
        public Long getCourseId() {
        return courseId;
        }

            public void setCourseId(Long courseId) {
        this.courseId = courseId;
        }
        public String getActivitieType() {
        return activitieType;
        }

            public void setActivitieType(String activitieType) {
        this.activitieType = activitieType;
        }
        public BigDecimal getActivitieNumber() {
        return activitieNumber;
        }

            public void setActivitieNumber(BigDecimal activitieNumber) {
        this.activitieNumber = activitieNumber;
        }
        public String getActivitieEndTime() {
        return activitieEndTime;
        }

            public void setActivitieEndTime(String activitieEndTime) {
        this.activitieEndTime = activitieEndTime;
        }

    @Override
    protected Serializable pkVal() {
        return this.activitieId;
    }

    @Override
    public String toString() {
    return "GuliActivitie{" +
            "activitieId=" + activitieId +
            ", courseId=" + courseId +
            ", activitieType=" + activitieType +
            ", activitieNumber=" + activitieNumber +
            ", activitieEndTime=" + activitieEndTime +
    "}";
    }
}
