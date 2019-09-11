package com.guli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guli.mapper.GuliEvaluateMapper;
import com.guli.pojo.GuliEvaluate;
import com.guli.service.GuliEvaluateService;
import com.guli.vo.GuliEvaluateVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * ???۱ 服务实现类
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@Service
public class GuliEvaluateServiceImpl extends ServiceImpl<GuliEvaluateMapper, GuliEvaluate> implements GuliEvaluateService {

    @Autowired
    private GuliEvaluateMapper guliEvaluateMapper;

    public List<GuliEvaluateVO> pageJG(Page<GuliEvaluateVO> page,int num) {
        return this.baseMapper.page(page,num);
    }
}
