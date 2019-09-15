package com.guli.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.pojo.GuliCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guli.pojo.coursevo.CourseAndClassifyAndUser;
import com.guli.pojo.request.PageCourse;
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

    IPage<GuliCourse> findAllPageCourse(Page<GuliCourse> guliCoursePage, PageCourse pageCourse);

    int pudeteCourseIdOneCourse(GuliCourse guliCourse);

    int updateCourseIdCourse(GuliCourse guliCourse);

    CourseAndClassifyAndUser findByCourseId(int courseId);
}
