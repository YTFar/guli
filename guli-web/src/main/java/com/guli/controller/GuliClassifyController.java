package com.guli.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guli.message.response.CommonCode;
import com.guli.pojo.GuliClassify;
import com.guli.response.ObjectResult;
import com.guli.service.GuliClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/guliClassify")
public class GuliClassifyController {

    @Autowired
    GuliClassifyService guliClassifyService;

    @RequestMapping(value = "/findAllClassify")
    public ObjectResult findAllClassify() {
        List<GuliClassify> list = guliClassifyService.findAllClassify();
        return new ObjectResult(CommonCode.SUCCESS,list);
    }

    /**
     * 查询二级课程分类
     * @return
     */
    @GetMapping("/findTwoClassify")
    public ObjectResult findTwoClassify(@RequestParam("id") int id) {
        List<GuliClassify> list = guliClassifyService.findTwoClassify(id);
        return new ObjectResult(CommonCode.SUCCESS,list);
    }

}
