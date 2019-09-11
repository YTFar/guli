package com.guli.mapper;

import com.guli.pojo.GuliClassify;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

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
}
