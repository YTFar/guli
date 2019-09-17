package com.guli.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guli.api.GuliSubdirectoryControllerApi;
import com.guli.mapper.GuliSubdirectoryMapper;
import com.guli.pojo.GuliSubdirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * ??Ŀ¼? 前端控制器
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@RestController
@RequestMapping("/guliSubdirectory")
public class GuliSubdirectoryController implements GuliSubdirectoryControllerApi {

    @Autowired
    private GuliSubdirectoryMapper guliSubdirectoryMapper;


    /**
     * 根据目录id查询课程子目录
     * @param id
     * @return
     */
    @Override
    @GetMapping("/findByIdSubdirectory")
    public List<GuliSubdirectory> findByIdSubdirectory(@RequestParam("id")int id) {
        return guliSubdirectoryMapper.selectList(
                new QueryWrapper<GuliSubdirectory>().eq("catalogue_id",id)
        );
    }
}
