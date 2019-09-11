package com.guli.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guli.message.response.CommonCode;
import com.guli.pojo.GuliClassify;
import com.guli.response.ObjectResult;
import com.guli.service.GuliClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guliClassify")
public class GuliClassifyController {

    @Autowired
    GuliClassifyService guliClassifyService;

    /**
     * 查询父级分类课程
     * @param id
     * @return
     */
    @GetMapping(value = "/findAllClassify")
    public ObjectResult findAllClassify(@RequestParam("id") int id) {
        List<GuliClassify> list = guliClassifyService.findAllClassify(id);
        return new ObjectResult(CommonCode.SUCCESS,list);
    }

    /**
     * 查询二级分类课程
     * @param id
     * @return
     */
    @GetMapping(value = "/findTwoClassify")
    public ObjectResult findTwoClassify(@RequestParam("id") int id){
        List<GuliClassify> list = guliClassifyService.findTwoClassify(id);
        return  new ObjectResult(CommonCode.SUCCESS,list);
    }
}
