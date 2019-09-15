package com.guli.pojo.coursevo;

import com.guli.pojo.GuliCourse;
import lombok.Data;
import lombok.ToString;

import java.time.format.DateTimeFormatter;

/**
 * @author 齐天大圣
 * @date 2019/9/14 10:23
 * @package com.guli.pojo.coursevo
 */
@Data
@ToString
public class CourseAndClassifyAndUser extends GuliCourse {

    //父id
    private int parentId;
    //二级分类名称
    private String classifyName;
    //父分类名称
    private String parentName;
    //教师id(课程发布人Id)
    private int userId;
    //教师名称(课程发布人)
    private String userName;
    //退款有效期(为0永久有效其他都是天数)
    private String courseValidityStr;
    //格式化时间-默认时间类型yyyy-MM-dd HH:mm:ss格式
    private String courseCreateTimeStr;

    public String getCourseValidityStr() {
        if(super.getCourseValidity().equals("0")){
            this.courseValidityStr = "永久有效";
        }else{
            this.courseValidityStr = super.getCourseValidity();
        }
        return courseValidityStr;
    }

    public String getCourseCreateTimeStr() {
        if (super.getCourseCreateTime()!=null){
            //yyyy-MM-dd HH:mm:ss
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
            this.courseCreateTimeStr = super.getCourseCreateTime().format(formatter);
        }
        return courseCreateTimeStr;
    }
}
