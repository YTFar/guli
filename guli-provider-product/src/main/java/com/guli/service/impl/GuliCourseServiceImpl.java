package com.guli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guli.mapper.GuliCourseMapper;
import com.guli.mapper.GuliItemMapper;
import com.guli.pojo.GuliCourse;
import com.guli.pojo.GuliItem;
import com.guli.pojo.coursevo.CourseAndClassifyAndUser;
import com.guli.service.GuliCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * ?γ̱ 服务实现类
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@Service
@Transactional
public class GuliCourseServiceImpl extends ServiceImpl<GuliCourseMapper, GuliCourse> implements GuliCourseService {

    @Autowired
    GuliItemMapper guliItemMapper;

    /**
     * 添加课程
     * @param guliCourse
     * @return
     */
    @Override
    @Transactional
    public GuliCourse addCourse(GuliCourse guliCourse) {
        //填写项的值
        GuliItem guliItem = new GuliItem();
        guliItem.setUserId(8l);
        guliItem.setCourseId(0l);
        guliItem.setCourseAffiliate(0);
        guliItem.setCourseCollect(0);
        //将项存入数据库并获取值
        guliItemMapper.insert(guliItem);
        Long insert = Long.valueOf(guliItem.getItemId());
        guliCourse.setItemId(insert);
        LocalDateTime localDateTime3 = LocalDateTime.now();
//        String format = localDateTime3.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        guliCourse.setCourseCreateTime(localDateTime3);
        guliCourse.setCourseWatched(0l);
        this.baseMapper.insert(guliCourse);
        Long insert1 = Long.valueOf(guliCourse.getCourseId());
        GuliItem guliItem1 = guliItemMapper.selectOne(new QueryWrapper<GuliItem>().eq("item_id",insert));
        guliItem1.setCourseId(insert1);
//        System.out.println(guliItem1);
        int i = guliItemMapper.updateById(guliItem1);
//        System.out.println(guliItem1);
        if(i < 1){
            return null;
        }
        return guliCourse;
    }

//    @Override
//    public IPage<GuliCourse> findAllPageCourse(Page<GuliCourse> guliCoursePage, PageCourse pageCourse) {
//        return this.baseMapper.findAllPageCourse(guliCoursePage,pageCourse);
//    }

    @Override
    public int pudeteCourseIdOneCourse(GuliCourse guliCourse) {
        return 0;
    }

    @Override
    @Transactional
    public int updateCourseIdCourse(GuliCourse guliCourse) {
        GuliCourse course = this.baseMapper.selectOne(new QueryWrapper<GuliCourse>().eq("course_id", guliCourse.getCourseId()));
        int update = this.baseMapper.update(course, new UpdateWrapper<GuliCourse>().set("course_name", guliCourse.getCourseName())
                .set("course_brief", guliCourse.getCourseBrief()).set("classify_id", guliCourse.getClassifyId()).set("course_image", guliCourse.getCourseImage())
                .set("course_price", guliCourse.getCoursePrice()).set("course_validity", guliCourse.getCourseValidity())
                .eq("course_id", guliCourse.getCourseId()));
        return update;
    }

    @Override
    public CourseAndClassifyAndUser findByCourseId(int courseId) {
        return this.baseMapper.findByCourseId(courseId);
    }

    @Override
    public List<GuliCourse> findAllPageCourse(Page<GuliCourse> page, int userId, String courseName) {
        return this.baseMapper.findAllPageCourse(page,userId,courseName);
    }
}
