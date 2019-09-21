package com.guli.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.pojo.GuliActivitie;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guli.pojo.activitievo.ActivitieAndCourse;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * ?? Mapper 接口
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
public interface GuliActivitieMapper extends BaseMapper<GuliActivitie> {

    //    @Select("SELECT a.*,b.course_name FROM guli_activitie a INNER JOIN guli_course b ON a.course_id = b.course_id INNER JOIN guli_item c ON b.course_id = c.course_id WHERE c.user_id = #{userId} ORDER BY activitie_id DESC")
    @Select({"<script>",
            "SELECT a.*,b.course_name,d.user_id,d.user_name",
            "FROM guli_activitie a",
            "INNER JOIN guli_course b ",
            "ON a.course_id = b.course_id",
            "INNER JOIN guli_item c",
            "ON b.course_id = c.course_id",
            "INNER JOIN guli_user d",
            "ON c.user_id = d.user_id",
            "<trim prefix=\"where\" prefixOverrides=\"and||or\">",
            "<if test=\"userId != null and userId != -1\">",
            "AND c.user_id = #{userId}",
            "</if>",
            "<if test=\"courseName != null and courseName != ''\">",
            "AND  b.course_name like concat('%',#{courseName},'%')",
            "</if>",
            "<if test=\"activitieType != null and activitieType != ''\">",
            "AND a.activitie_type = #{activitieType}",
            "</if>",
            "<if test=\"activitieState != null and activitieState != -1 \">",
            "AND a.activitie_state = #{activitieState}",
            "</if>",
            "</trim>",
            "ORDER BY activitie_id DESC",
            "</script>"})
    List<ActivitieAndCourse> findPageActivitie(Page<ActivitieAndCourse> page, @Param("userId") Long userId, @Param("activitieType") String activitieType, @Param("courseName") String courseName, @Param("activitieState") int activitieState);

    @Select({"<script>",
            "SELECT a.*,b.course_name,d.user_id,d.user_name",
            "FROM guli_activitie a",
            "INNER JOIN guli_course b ON a.course_id = b.course_id",
            "INNER JOIN guli_item c ON b.course_id = c.course_id",
            "INNER JOIN guli_user d ON c.user_id = d.user_id",
            " WHERE a.activitie_id = #{activitieId}",
//            " group by a.activitie_id having count(1) > 1",
            "</script>"})
    ActivitieAndCourse findActivitieIdActivitie(int activitieId);
}
