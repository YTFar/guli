package com.guli.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.guli.pojo.GuliCourse;
import com.guli.response.ObjectResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("GULI-PROVIDER-PRODUCT")
public interface GuliCourseService {

//    //注入工程客户端接口
//    @Autowired
//    GuliCourseClient guliCourseClient;

    @GetMapping(value = "/guliCourse/findWatched")
    List<GuliCourse> findWatchedCourse();

    @GetMapping(value = "/guliCourse/findNew")
    List<GuliCourse> findNewCourse();

    @GetMapping(value = "/guliCourse/findClassfiyCourse2")
    List<GuliCourse> findClassfiyCourse2(@RequestParam("parentId") int parentId);


    @GetMapping(value = "/guliCourse/findOneCourse")
    List<GuliCourse> findOneCourse(@RequestParam("id") int id);

    /**
     * 根据星评查询推荐课程
     * @return
     */
    @GetMapping(value = "/guliCourse/findRecommendCourse")
    List<GuliCourse> findRecommendCourse();

    /**
     * 查询全部分页
     * @return
     */
    @GetMapping(value = "/guliCourse/findPageAllCourse")
    IPage<GuliCourse> findPageAllCourse();

    /**
     * 根据二级分类id查询课程信息"
     * @param id
     * @return
     */
    @GetMapping("/findCourse")
    public List<GuliCourse> findCourse(@RequestParam("id") int id);

    /**
     * 判断课程名称是否存在
     * @param courseName
     * @return
     */
    @GetMapping("/guliCourse/isCourseName")
    public boolean isCourseName(@RequestParam("courseName") String courseName);

    @PostMapping("/guliCourse/addCourse")
    public GuliCourse addCourse(@RequestBody GuliCourse guliCourse);

}
