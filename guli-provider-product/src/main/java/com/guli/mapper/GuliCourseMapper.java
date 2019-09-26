package com.guli.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.pojo.GuliCourse;
import com.guli.pojo.coursevo.CourseAndClassify;
import com.guli.pojo.coursevo.CourseAndClassifyAndUser;
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

    /**
     * 根据id查询课程信息
     * @param id
     * @return
     */
    @Select("select * from guli_course a\n" +
            "INNER JOIN guli_activitie b ON b.course_id = a.course_id\n" +
            "WHERE a.course_id = #{id}")
    CourseVO findByIdCourse(@Param("id") int id);

    /**
     * 根据用户查询学习中的课程个数
     * @param id
     * @return
     */
    @Select("SELECT a.* FROM guli_course a\n" +
            "INNER JOIN guli_item b on a.course_id = b.course_id\n" +
            "WHERE b.course_affiliate = 1 and b.user_id = #{id}")
    List<GuliCourse> findCountCourseById(@Param("id") int id);

    /**
     * 根据课程id查询该课程下面的目录个数
     * @param id
     * @return
     */
    @Select("SELECT COUNT(0) FROM guli_subdirectory a WHERE a.catalogue_id IN (SELECT b.catalogue_id FROM guli_catalogue b WHERE b.course_id = #{id} ) AND a.subdirectory_type = 0")
    int findCountById(@Param("id") int id);

    /**
     * 根据用户id和课程id查询该课程下完成了多少个目录
     * @param uid
     * @param id
     * @return
     */
    @Select("SELECT COUNT(0) FROM guli_complete a\n" +
            "inner join guli_item b on a.item_id = b.item_id\n" +
            "WHERE b.user_id = #{uid} AND a.complete_status = 2 AND b.course_id = #{id}")
    int findCourseCount(@Param("uid") int uid, @Param("id") int id);
}
