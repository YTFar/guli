package com.guli.mapper;

import com.guli.pojo.GuliCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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


}
