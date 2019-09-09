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

    @Select("SELECT * FROM guli_course WHERE classify_id IN(SELECT classify_id FROM guli_classify WHERE classify_id = #{id}) LIMIT 8")
    List<GuliCourse> findOneCourse(int id);

}
