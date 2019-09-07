package com.guli.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guli.api.GuliUserControllerApi;
import com.guli.mapper.GuliUserMapper;
import com.guli.pojo.GuliUser;
import com.guli.response.ObjectResult;
import com.guli.service.GuliUserService;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.io.Console;
import java.util.List;

/**
 * <p>
 * ?û?? 前端控制器
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@RestController
@RequestMapping("/guliUser")
public class GuliUserController implements GuliUserControllerApi {

    @Autowired
    private GuliUserMapper guliUserMapper;

//    @Autowired
//    private GuliUserService guliUserService;



    @GetMapping("/login/{userName}/{pwd}")
    @Override
    public GuliUser login(@PathVariable("userName") String userName, @PathVariable("pwd") String pwd) {
        GuliUser guliUser = guliUserMapper.selectOne(new QueryWrapper<GuliUser>().eq("user_name", userName).eq("user_password", pwd));
        return guliUser;
    }
}
