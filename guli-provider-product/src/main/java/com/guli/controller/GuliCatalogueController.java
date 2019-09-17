package com.guli.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guli.api.GuliCatalogueControllerApi;
import com.guli.api.GuliClassifyControllerApi;
import com.guli.mapper.GuliCatalogueMapper;
import com.guli.pojo.GuliCatalogue;
import com.guli.pojo.GuliClassify;
import com.guli.response.ObjectResult;
import com.guli.service.GuliCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * ?γ?Ŀ¼? 前端控制器
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@RestController
@RequestMapping("/guliCatalogue")
public class GuliCatalogueController implements GuliCatalogueControllerApi {

    @Autowired
    private GuliCatalogueMapper guliCatalogueMapper;

    /**
     * 根据课程id查询目录
     * @param id
     * @return
     */
    @Override
    @GetMapping("/findByIdCatalogue")
    public List<GuliCatalogue> findByIdCatalogue(@RequestParam("id")int id) {
        return guliCatalogueMapper.selectList(
                new QueryWrapper<GuliCatalogue>().eq("course_id",id)
        );
    }
}
