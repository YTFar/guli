package com.guli.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.api.GuliActivitieControllerApi;
import com.guli.mapper.GuliActivitieMapper;
import com.guli.pojo.GuliActivitie;
import com.guli.pojo.activitievo.ActivitieAndCourse;
import com.guli.pojo.response.AllTypePage;
import com.guli.service.GuliActivitieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * ?? 前端控制器
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@RestController
@RequestMapping("/guliActivitie")
public class GuliActivitieController implements GuliActivitieControllerApi {

    @Autowired
    GuliActivitieService guliActivitieService;

    @Autowired
    GuliActivitieMapper guliActivitieMapper;

    /**
     * 添加课程活动
     * @param guliActivitie
     * @return 0 失败 1成功
     */
    @Override
    @PostMapping("/addActivitie")
    public int addActivitie(@RequestBody GuliActivitie guliActivitie) {
        return guliActivitieService.addActivitie(guliActivitie);
    }

    /**
     * 判断课程id此活动是否存在或是否结束
     * @param courseId
     * @return 0 不存在或进行中 1存在或结束
     */
    @Override
    @GetMapping("/findIsActivitie")
    public int findIsActivitie(@RequestParam("courseId") Long courseId) {
//        return guliActivitieService.findIsActivitie(courseId);
        return guliActivitieMapper.selectCount(new QueryWrapper<GuliActivitie>().eq("course_id",courseId).eq("activitie_state",1));
    }

    /**
     * 按id及其他条件分页查询出
     * @param pageNo 当前页数
     * @param pageSize 当前显示条数
     * @param userId 教师id (-1判断为管理员不使用)
     * @param activitieType 折扣类型
     * @param courseName 课程名称 为空时以*来代替(传值不能为空)
     * @param activitieState 当前状态
     * @return 分页列表
     */
    @Override
    @GetMapping("/findPageActivitie")
    public AllTypePage<ActivitieAndCourse> findPageActivitie(@RequestParam("pageNo") int pageNo,
                                                             @RequestParam("pageSize") int pageSize,
                                                             @RequestParam("userId") Long userId,
                                                             @RequestParam("activitieType") String activitieType,
                                                             @RequestParam("courseName") String courseName,
                                                             @RequestParam("activitieState") int activitieState) {
        Page<ActivitieAndCourse> page = new Page<ActivitieAndCourse>(pageNo, pageSize);
        page.setRecords(guliActivitieService.findPageActivitie(page,userId,activitieType,courseName,activitieState));
        AllTypePage<ActivitieAndCourse> allTypePage = new AllTypePage<ActivitieAndCourse>();
        allTypePage.setPageNo(pageNo);
        allTypePage.setPageSize(pageSize);
        allTypePage.setPageTotal((int) page.getTotal());
        allTypePage.setPageList(page.getRecords());
        return allTypePage;
    }

    /**
     *  按活动id查询活动详情
     * @param activitieId
     * @return 课程详情信息
     */
    @Override
    @GetMapping("/findActivitieIdActivitie")
    public ActivitieAndCourse findActivitieIdActivitie(@RequestParam("activitieId") int activitieId) {
        return this.guliActivitieMapper.findActivitieIdActivitie(activitieId);
    }

    /**
     * 按活动id修改指定活动
     * @param guliActivitie
     * @return
     */
    @Override
    @PutMapping("/updateActivitieIdActivitie")
    public int updateActivitieIdActivitie(@RequestBody GuliActivitie guliActivitie) {
        return guliActivitieService.updateActivitieIdActivitie(guliActivitie);
    }

    /**
     * 判断课程id此活动是否存在或是否结束排除自己
     * @param activitieId
     * @param courseId
     * @return
     */
    @Override
    @GetMapping("/findIsActivitieExcludeOneself")
    public int findIsActivitieExcludeOneself(@RequestParam("activitieId") Long activitieId,@RequestParam("courseId") Long courseId) {
//        System.out.println(123456789);
        return guliActivitieMapper.selectCount(new QueryWrapper<GuliActivitie>().eq("course_id",courseId).eq("activitie_state",1).ne("activitie_id",activitieId));
//        return 1;
    }
}
