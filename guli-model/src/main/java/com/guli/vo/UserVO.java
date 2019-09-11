package com.guli.vo;

import lombok.Data;

@Data
public class UserVO {

    //SELECT u.user_name,u.user_image,u.user_brief,(SELECT COUNT(course_id)  AS course_id FROM guli_item
    //WHERE user_id = 2) AS course_id,COUNT(c.user_id) AS user_id,COUNT(c.fans_id) AS fans_id FROM guli_concern c
    //INNER JOIN guli_user u ON u.user_id = c.user_id
    //WHERE u.user_id = 2


    //课程信息
//    SELECT a.activitie_type,a.activitie_number,a.activitie_end_time,c.course_name,course_brief,course_image,course_price,course_validity,c.course_watched FROM guli_course c
//    INNER JOIN guli_activitie a ON c.course_id = a.course_id
//    WHERE c.course_id = 3

    private String userName;
    private String userImage;
    private String userBrief;
    private String courseId;
    private String userId;
    private String fansId;

}
