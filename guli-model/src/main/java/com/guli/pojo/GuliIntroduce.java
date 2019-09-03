package com.guli.pojo;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.extension.activerecord.Model;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * ?γ̽??ܱ
    * </p>
*
* @author slz
* @since 2019-09-03
*/
    public class GuliIntroduce extends Model<GuliIntroduce> {

    private static final long serialVersionUID = 1L;

            @TableId(value = "introduce_id", type = IdType.AUTO)
    private Long introduceId;

    private Long courseId;

    private String introduceName;

    private String introduceProgram;

    private String introduceTarget;

        public Long getIntroduceId() {
        return introduceId;
        }

            public void setIntroduceId(Long introduceId) {
        this.introduceId = introduceId;
        }
        public Long getCourseId() {
        return courseId;
        }

            public void setCourseId(Long courseId) {
        this.courseId = courseId;
        }
        public String getIntroduceName() {
        return introduceName;
        }

            public void setIntroduceName(String introduceName) {
        this.introduceName = introduceName;
        }
        public String getIntroduceProgram() {
        return introduceProgram;
        }

            public void setIntroduceProgram(String introduceProgram) {
        this.introduceProgram = introduceProgram;
        }
        public String getIntroduceTarget() {
        return introduceTarget;
        }

            public void setIntroduceTarget(String introduceTarget) {
        this.introduceTarget = introduceTarget;
        }

    @Override
    protected Serializable pkVal() {
        return this.introduceId;
    }

    @Override
    public String toString() {
    return "GuliIntroduce{" +
            "introduceId=" + introduceId +
            ", courseId=" + courseId +
            ", introduceName=" + introduceName +
            ", introduceProgram=" + introduceProgram +
            ", introduceTarget=" + introduceTarget +
    "}";
    }
}
