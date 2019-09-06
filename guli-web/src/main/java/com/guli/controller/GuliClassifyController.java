package com.guli.controller;

import com.guli.message.response.CommonCode;
import com.guli.pojo.GuliClassify;
import com.guli.response.ObjectResult;
import com.guli.product.service.GuliClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
