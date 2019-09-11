package com.guli.mapper;

        import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
        import com.baomidou.mybatisplus.core.metadata.IPage;
        import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
        import com.guli.pojo.GuliEvaluate;
        import com.baomidou.mybatisplus.core.mapper.BaseMapper;
        import com.guli.vo.CourseVO;
        import com.guli.vo.GuliEvaluateVO;
        import com.guli.vo.UserVO;
        import org.apache.ibatis.annotations.Param;
        import org.apache.ibatis.annotations.Select;

        import java.util.List;

/**
 * <p>
 * ???۱ Mapper 接口
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
public interface GuliEvaluateMapper extends BaseMapper<GuliEvaluate> {

    @Select("SELECT c.course_name,c.course_id,e.evaluate_content,DATE_FORMAT(e.evaluate_create_time,'%m-%d') AS evaluate_create_time,u.user_id,u.user_name,u.user_image,e.evaluate_rating FROM guli_evaluate e\n" +
            "INNER JOIN guli_item i ON e.item_id = i.item_id\n" +
            "INNER JOIN guli_course c ON i.item_id = c.item_id\n" +
            "INNER JOIN guli_user u ON i.user_id = u.user_id\n" +
            "ORDER BY evaluate_create_time DESC\n" +
            "LIMIT 20")
    public List<GuliEvaluateVO> findAllEvaluate();

    @Select("SELECT c.course_name,c.course_id,e.evaluate_content,DATE_FORMAT(e.evaluate_create_time,'%m-%d') AS evaluate_create_time,u.user_id,u.user_name,u.user_iamge,e.evaluate_rating FROM guli_evaluate e INNER JOIN guli_item i ON e.item_id = i.item_id INNER JOIN guli_course c ON i.item_id = c.item_id INNER JOIN guli_user u ON i.user_id = u.user_id WHERE c.course_id > #{num}")
    List<GuliEvaluateVO> page(Page<GuliEvaluateVO> page,@Param("num") int num);

    @Select("SELECT u.user_name,u.user_image,u.user_brief,(SELECT COUNT(course_id)  AS course_id FROM guli_item\n" +
            "WHERE user_id = #{num}) AS course_id,COUNT(c.user_id) AS user_id,COUNT(c.fans_id) AS fans_id FROM guli_concern c\n" +
            "INNER JOIN guli_user u ON u.user_id = c.user_id\n" +
            "WHERE u.user_id = #{num}")
    UserVO findByIdUser(@Param("num") int num);

    @Select("SELECT a.activitie_type,a.activitie_number,a.activitie_end_time,c.course_name,course_brief,course_image,course_price,course_validity,c.course_watched FROM guli_course c\n"+
           "INNER JOIN guli_activitie a ON c.course_id = a.course_id\n"+
           "WHERE c.course_id = #{num}")
    CourseVO findByIdCourse(@Param("num") int num);
}
