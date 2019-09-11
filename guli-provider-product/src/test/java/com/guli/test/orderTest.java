package com.guli.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.controller.GuliCourseController;
import com.guli.mapper.GuliCourseMapper;
import com.guli.pojo.GuliCourse;
import com.guli.pojo.request.PageCourse;
import com.guli.service.GuliCourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class orderTest {

    @Autowired
    GuliCourseMapper guliCourseMapper;

    @Autowired
    GuliCourseController guliCourseController;

    @Autowired
    GuliCourseService guliCourseService;

    @Test
    public void OrderPageTest(){
//        Page<GuliCourse> page = new Page<GuliCourse>(1,3);
//        IPage<GuliCourse> guliCourseIPage = guliCourseMapper.selectPage(new Page<GuliCourse>(1,3), new QueryWrapper<GuliCourse>().inSql("course_id", "select course_id from guli_item where user_id = 1").like("course_name", ""));
        PageCourse pageCourse = new PageCourse();
        pageCourse.setPageNo(1);
        pageCourse.setPageSize(3);
        pageCourse.setUserId(1);
        pageCourse.setCourseName(null);
        IPage<GuliCourse> guliCourseIPage = guliCourseService.findAllPageCourse(new Page<GuliCourse>(1, 3), pageCourse);
        System.out.println(guliCourseIPage);
        for (int i = 0; i < guliCourseIPage.getRecords().size(); i++) {
            System.out.println(guliCourseIPage.getRecords().get(i));
        }
    }

}
