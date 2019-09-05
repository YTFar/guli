package com.guli.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guli.message.response.CommonCode;
import com.guli.pojo.GuliUser;
import com.guli.response.ObjectCode;
import com.guli.response.ObjectResult;
import com.guli.service.GuliUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guliUser")
public class GuliUserController {

    @Autowired
    GuliUserService guliUserService;
    @PostMapping("/login")
    public ObjectResult login(@PathVariable("userName") String userName, @PathVariable("pwd") String pwd) {
        GuliUser guliUser = guliUserService.login(userName,pwd);
        return new ObjectResult(CommonCode.SUCCESS,guliUser);
    }

}
