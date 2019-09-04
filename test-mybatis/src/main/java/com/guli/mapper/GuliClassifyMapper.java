package com.guli.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.pojo.GuliClassify;

/**
 * <p>
 * ????? Mapper 接口
 * </p>
 *
 * @author slz
 * @since 2019-09-02
 */
public interface GuliClassifyMapper extends BaseMapper<GuliClassify> {

    IPage<GuliClassify> selectPageVo(Page page);

    IPage<GuliClassify> selectPageVo2(Page page);
}
