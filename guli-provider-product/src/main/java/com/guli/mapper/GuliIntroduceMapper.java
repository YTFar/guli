package com.guli.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.pojo.GuliIntroduce;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guli.pojo.introducevo.IntroduceAndCourse;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * ?γ̽??ܱ Mapper 接口
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
public interface GuliIntroduceMapper extends BaseMapper<GuliIntroduce> {

    @Select({"<script>",
            "SELECT a.*,b.course_name,d.user_id,d.user_name FROM guli_introduce a",
            "INNER JOIN guli_course b ON a.course_id = b.course_id",
            "INNER JOIN guli_item c ON b.item_id = c.item_id",
            "INNER JOIN guli_user d ON c.user_id = d.user_id",
            "<trim prefix=\"where\" prefixOverrides=\"and||or\">",
            "<if test=\"userId != null and userId != -1\">",
            "AND d.user_id = #{userId}",
            "</if>",
            "<if test=\"courseName != null and courseName != ''\">",
            "AND course_name like concat('%',#{courseName},'%')",
            "</if>",
            "</trim>",
            "ORDER BY introduce_id DESC",
            "</script>"})
    List<IntroduceAndCourse> findAllPageIntroduce(Page<IntroduceAndCourse> page, @Param("userId") Long userId, @Param("courseName") String courseName);

    @Select({"<script>",
            "SELECT a.*,b.course_name,d.user_id,d.user_name FROM guli_introduce a",
            "INNER JOIN guli_course b ON a.course_id = b.course_id",
            "INNER JOIN guli_item c ON b.item_id = c.item_id",
            "INNER JOIN guli_user d ON c.user_id = d.user_id",
            "WHERE a.introduce_id = #{introduceId}",
            "</script>"})
    IntroduceAndCourse findOneIntroduce(int introduceId);
}
