package com.guli.pojo.request;

import lombok.Data;
import lombok.ToString;

/**
 * @author 齐天大圣
 * @date 2019/9/11 9:07
 * @package com.guli.pojo.request
 */
@Data
@ToString
public class PageCourse {
    private int pageNo;
    private int pageSize;
    private int userId;
    private String courseName;
}
