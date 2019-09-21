package com.guli.pojo.introducevo;

import com.guli.pojo.GuliIntroduce;
import lombok.Data;
import lombok.ToString;

/**
 * @author 齐天大圣
 * @date 2019/9/18 11:06
 * @package com.guli.pojo.introducevo
 */
@Data
@ToString
public class IntroduceAndCourse extends GuliIntroduce {
    private Long userId;
    private String courseName;
    private String userName;
    private String introduceProgramStr;
    private String introduceTargetStr;

    public String getIntroduceProgramStr() {
        this.introduceProgramStr = super.getIntroduceProgram() == null ? "无内容" : super.getIntroduceProgram();
        return introduceProgramStr;
    }

    public String getIntroduceTargetStr() {
        this.introduceTargetStr = super.getIntroduceTarget() == null ? "无内容" : super.getIntroduceTarget();
        return introduceTargetStr;
    }

}
