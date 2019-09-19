package com.guli.vo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.math.BigDecimal;

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
    private String userImage;
    private String evaluateRating;


    private String courseImage;
    private BigDecimal coursePrice;

}
