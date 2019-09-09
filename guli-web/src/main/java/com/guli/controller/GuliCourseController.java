package com.guli.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guli.message.response.CommonCode;
import com.guli.pojo.GuliCourse;
import com.guli.response.ObjectResult;
import com.guli.service.GuliCourseService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * ?γ̱ 前端控制器
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@RestController
@RequestMapping("/guliCourse")
public class GuliCourseController {

    @Autowired
    GuliCourseService guliCourseService;

    @GetMapping("/findAll")
    public ObjectResult findAllCourse() {
        return null;
    }

    /**
     * 首页查询热门课程
     */
    @GetMapping("/findWatched")
    public ObjectResult findWatchedCourse() {
        List<GuliCourse> watchedCourse = guliCourseService.findWatchedCourse();
        return new ObjectResult(CommonCode.SUCCESS,watchedCourse);
    }

    /**
     * 首页查询最新课程
     * @return
     */
    @GetMapping("/findNew")
    public ObjectResult findNewCourse(){
        List<GuliCourse> newCourse = guliCourseService.findNewCourse();
        return new ObjectResult(CommonCode.SUCCESS,newCourse);
    }


    /**
     * 根据二级分类id查询课程信息"
     * @param id
     * @return
     */
    @GetMapping("/findCourse")
    public ObjectResult findCourse(@RequestParam("id") int id) {
        List<GuliCourse> list = guliCourseService.findCourse(id);
        return new ObjectResult(CommonCode.SUCCESS,list);
    }


//    /**
//     * 查询课程子分类
//     * @return
//     */
//    @GetMapping("/guliCourse")
//    public ObjectResult findClassfiyCourse2(@RequestParam("parentId") int parentId){
//        List<GuliCourse> classfiyCourse2 = guliCourseService.findClassfiyCourse2(parentId);
//        return new ObjectResult(CommonCode.SUCCESS,classfiyCourse2);
//    }

    /**
     * 根据一级分类id查课程
     * @param id
     * @return
     */
    @GetMapping("/findOneCourse")
    public ObjectResult findOneCourse(@RequestParam("id") int id){
        List<GuliCourse> list = guliCourseService.findCourse(id);
        return new ObjectResult(CommonCode.SUCCESS,list);
    }

}
