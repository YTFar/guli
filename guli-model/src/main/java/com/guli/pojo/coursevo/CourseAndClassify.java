package com.guli.pojo.coursevo;

import com.guli.pojo.GuliCourse;
import lombok.Data;
import lombok.ToString;

/**
 * @author 齐天大圣
 * @date 2019/9/12 10:15
 * @package com.guli.pojo.coursevo
 */
@Data
@ToString
public class CourseAndClassify extends GuliCourse {
    private int parentId;
}
