package com.guli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.pojo.GuliIntroduce;
import com.guli.mapper.GuliIntroduceMapper;
import com.guli.pojo.introducevo.IntroduceAndCourse;
import com.guli.service.GuliIntroduceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * ?γ̽??ܱ 服务实现类
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@Service
public class GuliIntroduceServiceImpl extends ServiceImpl<GuliIntroduceMapper, GuliIntroduce> implements GuliIntroduceService {

    @Override
    @Transactional
    public int addIntroduce(GuliIntroduce guliIntroduce) {
        return this.baseMapper.insert(guliIntroduce);
    }

    @Override
    public int findIsIntroduce(Long courseId) {
        return this.baseMapper.selectCount(new QueryWrapper<GuliIntroduce>().eq("course_id",courseId));
    }

    @Override
    public List<IntroduceAndCourse> findAllPageIntroduce(Page<IntroduceAndCourse> page, Long userId, String courseName) {
        return this.baseMapper.findAllPageIntroduce(page,userId,courseName);
    }

    @Override
    public IntroduceAndCourse findOneIntroduce(int introduceId) {
        return this.baseMapper.findOneIntroduce(introduceId);
    }

    @Override
    @Transactional
    public int updeteIntroduce(GuliIntroduce guliIntroduce) {
        GuliIntroduce introduce = this.baseMapper.selectOne(new QueryWrapper<GuliIntroduce>().eq("introduce_id", guliIntroduce.getIntroduceId()));
        if(guliIntroduce.getIntroduceName()!=null)
            introduce.setIntroduceName(guliIntroduce.getIntroduceName());
        if(guliIntroduce.getIntroduceProgram()!=null)
            introduce.setIntroduceProgram(guliIntroduce.getIntroduceProgram());
        if (guliIntroduce.getIntroduceTarget()!=null)
            introduce.setIntroduceTarget(guliIntroduce.getIntroduceTarget());
        return this.baseMapper.updateById(introduce);
    }
}
