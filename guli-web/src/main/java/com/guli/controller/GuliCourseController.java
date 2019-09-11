package com.guli.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
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

    /**
     * 根据星评查询推荐课程
     * @return
     */
    @GetMapping("/findRecommendCourse")
    public ObjectResult findRecommendCourse(){
        List<GuliCourse> list = guliCourseService.findRecommendCourse();
        return  new ObjectResult(CommonCode.SUCCESS,list);
    }

    /**
     * 查询全部课程进行分页
     * @return
     */
    @GetMapping("/findPageAllCourse")
    public IPage<GuliCourse> findPageAllCourse(){
        IPage<GuliCourse> page = guliCourseService.findPageAllCourse();
        return page;
    }

    /**
     * 查询课程名是否存在
     * @param courseName
     * @return
     */
    @GetMapping("/isCourseName")
    public ObjectResult isCourseName(@RequestParam("courseName") String courseName){
        boolean b = guliCourseService.isCourseName(courseName);
//        System.out.println(b);
        return new ObjectResult(CommonCode.SUCCESS,b);
    }

    /**
     * 添加课程
     * @param guliCourse
     * @return
     */
    @PostMapping("/addCourse")
    public ObjectResult addCourse(@RequestBody GuliCourse guliCourse) {
//        System.out.println(guliCourse);
        boolean courseName = guliCourseService.isCourseName(guliCourse.getCourseName());
        if(courseName == false){
            return new ObjectResult(CommonCode.FAIL,null);
        }
        return new ObjectResult(CommonCode.SUCCESS,guliCourseService.addCourse(guliCourse));
    }
}
