package com.guli.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.pojo.GuliEvaluate;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guli.vo.GuliEvaluateVO;

import java.util.List;

/**
 * <p>
 * ???۱ 服务类
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
public interface GuliEvaluateService extends IService<GuliEvaluate> {

    List<GuliEvaluateVO> pageJG(Page<GuliEvaluateVO> page,int num);
}

