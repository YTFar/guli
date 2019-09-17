package com.guli.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guli.api.GuliIntroduceControllerApi;
import com.guli.mapper.GuliIntroduceMapper;
import com.guli.pojo.GuliIntroduce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    private GuliIntroduceMapper guliIntroduceMapper;

    /**
     * 根据课程id查询课程评价
     * @param id
     * @return
     */
    @Override
    @GetMapping("/findByIdIntroduce")
    public GuliIntroduce findByIdIntroduce(@RequestParam("id") int id) {
        return guliIntroduceMapper.selectOne(new QueryWrapper<GuliIntroduce>().eq("course_id",id));
    }
}
