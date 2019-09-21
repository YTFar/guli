package com.guli.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.pojo.GuliIntroduce;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guli.pojo.introducevo.IntroduceAndCourse;

import java.util.List;

/**
 * <p>
 * ?γ̽??ܱ 服务类
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
public interface GuliIntroduceService extends IService<GuliIntroduce> {

    int addIntroduce(GuliIntroduce guliIntroduce);

    int findIsIntroduce(Long courseId);

    List<IntroduceAndCourse> findAllPageIntroduce(Page<IntroduceAndCourse> page, Long userId, String courseName);

    IntroduceAndCourse findOneIntroduce(int introduceId);

    int updeteIntroduce(GuliIntroduce guliIntroduce);
}
