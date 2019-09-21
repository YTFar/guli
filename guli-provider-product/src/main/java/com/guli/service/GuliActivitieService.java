package com.guli.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.pojo.GuliActivitie;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guli.pojo.activitievo.ActivitieAndCourse;

import java.util.List;

/**
 * <p>
 * ?? 服务类
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
public interface GuliActivitieService extends IService<GuliActivitie> {

    int addActivitie(GuliActivitie guliActivitie);

    List<ActivitieAndCourse> findPageActivitie(Page<ActivitieAndCourse> page, Long userId, String activitieType, String courseName, int activitieState);

    int updateActivitieIdActivitie(GuliActivitie guliActivitie);

    int findIsActivitie(Long courseId);
}
