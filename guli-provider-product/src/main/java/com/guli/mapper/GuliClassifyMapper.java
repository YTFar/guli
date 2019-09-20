package com.guli.mapper;

import com.guli.pojo.GuliClassify;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guli.pojo.classifyvo.ClassifyNode;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 * ????? Mapper 接口
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
public interface GuliClassifyMapper extends BaseMapper<GuliClassify> {
    /**
     * 查询课程二级分类
     * @param id
     * @return
     */
    @Select("select * from guli_classify where parent_id=(select classify_id from guli_classify where classify_id=#{id})")
        List<GuliClassify>findTwoClassify(int id);

    @Select("select * from guli_classify where parent_id = 0")
    @Results({
            @Result(id = true,property = "classifyId",column = "classify_id"),
            @Result(property = "title",column = "classify_name"),
            @Result(property = "children",column = "classify_id",javaType =java.util.List.class,many = @Many(select = "com.guli.mapper.GuliClassifyMapper.findAllChildren"))
    })
    List<ClassifyNode> findAllClassifyNode();

    @Select("select * from guli_classify where classify_id in (select classify_id from guli_classify where parent_id = #{classifyId})")
    @Results({
            @Result(id = true,property = "classifyId",column = "classify_id"),
            @Result(property = "title",column = "classify_name")
    })
    List<ClassifyNode> findAllChildren(int classifyId);
}
