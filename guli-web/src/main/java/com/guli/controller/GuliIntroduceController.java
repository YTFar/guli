package com.guli.controller;


import com.guli.message.response.CommonCode;
import com.guli.pojo.GuliIntroduce;
import com.guli.response.ObjectResult;
import com.guli.service.GuliIntroduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class GuliIntroduceController {

    @Autowired
    GuliIntroduceService guliIntroduceService;

    @GetMapping("/findByIdIntroduce")
    ObjectResult findByIdIntroduce(@RequestParam("id") int id){
        return new ObjectResult(CommonCode.SUCCESS,guliIntroduceService.findByIdIntroduce(id));
    }

}
