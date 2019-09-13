package com.guli.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.guli.mapper.GuliCourseMapper;
import com.guli.pojo.GuliCourse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 齐天大圣
 * @date 2019/9/12 14:55
 * @package com.guli.test
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class courseTest {

    @Autowired
    GuliCourseMapper guliCourseMapper;

    @Test
    public void updateCourseTest(){
//        GuliCourse course_id = guliCourseMapper.selectOne(new QueryWrapper<GuliCourse>().eq("course_id", 1));
        GuliCourse guliCourse = new GuliCourse();
        guliCourse.setCourseId(1l);
        guliCourse.setCourseName("你好");
        int update = guliCourseMapper.update(guliCourse, new UpdateWrapper<GuliCourse>().set("course_name", "面向对象").set("course_name", "面向对象").eq("course_id", 1));
        System.out.println(guliCourse);
    }

}
