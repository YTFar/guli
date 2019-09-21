package com.guli.pojo.activitievo;

import com.guli.pojo.GuliActivitie;
import lombok.Data;
import lombok.ToString;

/**
 * @author 齐天大圣
 * @date 2019/9/16 10:38
 * @package com.guli.pojo.activitievo
 */
@Data
@ToString
public class ActivitieAndCourse extends GuliActivitie {

    private String courseName;

    private String activitieStateStr;

    private String activitieEndTimeStr;

    private Long userId;

    private String userName;

    public String getActivitieEndTimeStr() {
        this.activitieEndTimeStr = super.getActivitieEndTime() == null ? "永久" : super.getActivitieEndTime();
        return activitieEndTimeStr;
    }

    public String getActivitieStateStr() {
        this.activitieStateStr = super.getActivitieState() == 0 ? "已结束" : "进行中";
        return activitieStateStr;
    }
}
