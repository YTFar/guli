package com.guli.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.pojo.GuliCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guli.pojo.coursevo.CourseAndClassify;
import com.guli.pojo.coursevo.CourseAndClassifyAndUser;
import com.guli.pojo.request.PageCourse;
import com.guli.vo.CourseVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * ?γ̱ Mapper 接口
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
public interface GuliCourseMapper extends BaseMapper<GuliCourse> {


    /**
     * 查询课程信息分类
     * @param id
     * @return
     */
    @Select("SELECT * FROM guli_course WHERE classify_id IN(SELECT classify_id FROM guli_classify WHERE classify_id = #{id}) LIMIT 8")
    List<GuliCourse> findOneCourse(int id);

    /**
     * 根据星评查询推荐课程
     * @return
     */
    @Select("select * from guli_course c \n" +
            "INNER JOIN guli_evaluate e\n" +
            "on c.item_id = e.item_id\n" +
            "ORDER BY evaluate_rating DESC")
    List<GuliCourse> findRecommendCourse();


    @Select({"<script>",
            "SELECT * FROM guli_course",
            "<trim prefix=\"where\" prefixOverrides=\"and||or\">",
            "<if test=\"userId != null and userId != -1\">",
            "AND course_id in (select course_id from guli_item where user_id = #{userId})",
            "</if>",
            "<if test=\"courseName != null and courseName != ''\">",
            "AND course_name like concat('%',#{courseName},'%')",
            "</if>",
            "</trim>",
            "ORDER BY course_create_time DESC",
            "</script>"})
    List<GuliCourse> findAllPageCourse(Page<GuliCourse> guliCoursePage, @Param("userId") int userId, @Param("courseName") String courseName);

    @Select("SELECT a.*,b.parent_id FROM guli_course a INNER JOIN guli_classify b ON a.classify_id = b.classify_id WHERE a.course_id = #{id}")
    CourseAndClassify findCourseIdOneCourse(int id);

    @Select({"<script>",
            "SELECT",
            "a.*,c.user_id,c.user_name,d.classify_name,d.parent_id,e.classify_name as parentName",
            "FROM guli_course a",
            "INNER JOIN guli_item b ON a.item_id = b.item_id",
            "INNER JOIN guli_user c ON b.user_id = c.user_id",
            "INNER JOIN guli_classify d ON a.classify_id = d.classify_id",
            "INNER JOIN guli_classify e ON d.parent_id = e.classify_id",
            "where a.course_id = #{courseId}",
            "</script>"})
    CourseAndClassifyAndUser findByCourseId(int courseId);
}
