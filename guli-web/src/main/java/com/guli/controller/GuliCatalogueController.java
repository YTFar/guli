package com.guli.controller;


import com.guli.api.GuliClassifyControllerApi;
import com.guli.message.response.CommonCode;
import com.guli.pojo.GuliClassify;
import com.guli.response.ObjectResult;
import com.guli.service.GuliCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class GuliCatalogueController{

    @Autowired
    private GuliCatalogueService guliCatalogueService;

    /**
     * 根据课程id查询课程目录
     * @param id
     * @return
     */
    @GetMapping("/findByIdCatalogue")
    public ObjectResult findByIdCatalogue(@RequestParam("id")int id){
        return new ObjectResult(CommonCode.SUCCESS,guliCatalogueService.findByIdCatalogue(id));
    }

}
