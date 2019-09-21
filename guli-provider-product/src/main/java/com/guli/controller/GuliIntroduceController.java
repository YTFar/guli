package com.guli.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.api.GuliIntroduceControllerApi;
import com.guli.mapper.GuliIntroduceMapper;
//import com.guli.page.PagePackaging;
import com.guli.pojo.GuliIntroduce;
import com.guli.pojo.activitievo.ActivitieAndCourse;
import com.guli.pojo.introducevo.IntroduceAndCourse;
import com.guli.pojo.response.AllTypePage;
import com.guli.service.GuliIntroduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * ?γ̽??ܱ 前端控制器
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@RestController
@RequestMapping("/guliIntroduce")
public class GuliIntroduceController implements GuliIntroduceControllerApi {


    @Autowired
    GuliIntroduceService guliIntroduceService;

    /**
     * 添加详情介绍信息
     * @param guliIntroduce
     * @return 0 失败 1成功
     */
    @Override
    @PostMapping("/addIntroduce")
    public int addIntroduce(@RequestBody GuliIntroduce guliIntroduce) {
        return guliIntroduceService.addIntroduce(guliIntroduce);
    }

    /**
     * 按课程id查询此课程是否存在
     * @param courseId
     * @return 0 不存在 1 存在
     */
    @Override
    @GetMapping("/findIsIntroduce")
    public int findIsIntroduce(@RequestParam("courseId") Long courseId) {
        return guliIntroduceService.findIsIntroduce(courseId);
    }

    /**
     * 按条件分页查询详情介绍信息
     * @param pageNo 页数
     * @param pageSize 数据量
     * @param userId
     * @param courseName
     * @return
     */
    @Override
    @GetMapping("/findAllPageIntroduce")
    public AllTypePage<IntroduceAndCourse> findAllPageIntroduce(@RequestParam("pageNo") int pageNo,@RequestParam("pageSize") int pageSize,@RequestParam("userId") Long userId,@RequestParam("courseName") String courseName) {
        if(courseName.equals("*")){
            courseName = "";
        }
        Page<IntroduceAndCourse> page = new Page<IntroduceAndCourse>(pageNo,pageSize);
        page.setRecords(guliIntroduceService.findAllPageIntroduce(page,userId,courseName));
//        PagePackaging<IntroduceAndCourse> pagePackaging = new PagePackaging<>();
//        return  pagePackaging.pagePackaging(pageNo,pageSize,(int)page.getTotal(),page.getRecords());
        AllTypePage<IntroduceAndCourse> allTypePage = new AllTypePage<IntroduceAndCourse>();
        allTypePage.setPageNo(pageNo);
        allTypePage.setPageSize(pageSize);
        allTypePage.setPageTotal((int) page.getTotal());
        allTypePage.setPageList(page.getRecords());
        return allTypePage;
    }

    /**
     * 按介绍id查询详情介绍信息
     * @param introduceId
     * @return
     */
    @Override
    @GetMapping("/findOneIntroduce")
    public IntroduceAndCourse findOneIntroduce(@RequestParam("introduceId") int introduceId) {
        return guliIntroduceService.findOneIntroduce(introduceId);
    }

    /**
     * 按id修改指定介绍信息
     * @param guliIntroduce
     * @return
     */
    @Override
    @PutMapping("/updateIntroduce")
    public int updateIntroduce(@RequestBody GuliIntroduce guliIntroduce) {
        return guliIntroduceService.updeteIntroduce(guliIntroduce);
    }
}
