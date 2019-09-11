package com.guli.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 *
 */
@Data
public class GuliEvaluateVO extends Model<GuliEvaluateVO> {

    private String courseName;
    private String courseId;
    private String evaluateContent;
    private String evaluateCreateTime;
    private String userId;
    private String userName;
    private String userIamge;
    private String evaluateRating;

}
