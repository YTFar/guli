package com.guli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.pojo.GuliActivitie;
import com.guli.mapper.GuliActivitieMapper;
import com.guli.pojo.activitievo.ActivitieAndCourse;
import com.guli.service.GuliActivitieService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * ?? 服务实现类
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@Service
@Transactional
public class GuliActivitieServiceImpl extends ServiceImpl<GuliActivitieMapper, GuliActivitie> implements GuliActivitieService {

    @Override
    @Transactional
    public int addActivitie(GuliActivitie guliActivitie) {
        return this.baseMapper.insert(guliActivitie);
    }

    @Override
    public List<ActivitieAndCourse> findPageActivitie(Page<ActivitieAndCourse> page, Long userId, String activitieType, String courseName, int activitieState) {
        if(courseName.equals("*")){
            courseName = "";
        }
        if(activitieType.equals("*")){
            activitieType = "";
        }
        return this.baseMapper.findPageActivitie(page,userId,activitieType,courseName,activitieState);
    }

    @Override
    @Transactional
    public int updateActivitieIdActivitie(GuliActivitie guliActivitie) {
        GuliActivitie activitie_id = this.baseMapper.selectOne(new QueryWrapper<GuliActivitie>().eq("activitie_id", guliActivitie.getActivitieId()));
        if(guliActivitie.getActivitieNumber() != null)
            activitie_id.setActivitieNumber(guliActivitie.getActivitieNumber());
        if(guliActivitie.getActivitieEndTime() != null)
            activitie_id.setActivitieEndTime(guliActivitie.getActivitieEndTime());
        if(guliActivitie.getActivitieType() != null)
            activitie_id.setActivitieType(guliActivitie.getActivitieType());
        if(guliActivitie.getActivitieState() != null)
            activitie_id.setActivitieState(guliActivitie.getActivitieState());
        return this.baseMapper.updateById(activitie_id);
    }

    @Override
    public int findIsActivitie(Long courseId) {
        return this.baseMapper.selectCount(new QueryWrapper<GuliActivitie>().eq("course_id",courseId).eq("activitie_state",1));
    }
}
