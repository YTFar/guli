package com.guli.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guli.api.GuliActivitieControllerApi;
import com.guli.mapper.GuliActivitieMapper;
import com.guli.pojo.GuliActivitie;
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
        return guliActivitieMapper.selectCount(new QueryWrapper<GuliActivitie>().eq("course_id",courseId).eq("activitie_state",1));
    }
}
