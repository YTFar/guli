package com.guli.controller;


import com.guli.message.response.CommonCode;
import com.guli.pojo.GuliCourse;
import com.guli.response.ObjectResult;
import com.guli.service.GuliCourseService;
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
    @RequestMapping("/findWatched")
    public ObjectResult findWatchedCourse() {
        List<GuliCourse> watchedCourse = guliCourseService.findWatchedCourse();
        return new ObjectResult(CommonCode.SUCCESS,watchedCourse);
    }

    /**
     * 首页查询最新课程
     * @return
     */
    @RequestMapping("/findNew")
    public ObjectResult findNewCourse(){
        List<GuliCourse> newCourse = guliCourseService.findNewCourse();
        return new ObjectResult(CommonCode.SUCCESS,newCourse);
    }


}
