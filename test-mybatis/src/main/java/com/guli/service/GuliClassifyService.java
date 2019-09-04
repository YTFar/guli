package com.guli.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guli.pojo.GuliClassify;

/**
 * <p>
 * ????? 服务类
 * </p>
 *
 * @author slz
 * @since 2019-09-02
 */
public interface GuliClassifyService extends IService<GuliClassify> {

    IPage<GuliClassify> fenYe(Page page);

    IPage<GuliClassify> fenYe2(Page page);
}
