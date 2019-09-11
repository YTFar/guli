package com.guli.service;

import com.guli.pojo.GuliCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guli.response.ObjectResult;

/**
 * <p>
 * ?γ̱ 服务类
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
public interface GuliCourseService extends IService<GuliCourse> {

    GuliCourse addCourse(GuliCourse guliCourse);
}
