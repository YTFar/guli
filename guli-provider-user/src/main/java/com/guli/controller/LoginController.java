package com.guli.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guli.api.LoginControllerApi;
import com.guli.mapper.GuliUserMapper;
import com.guli.pojo.GuliUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController implements LoginControllerApi {


    @Autowired
    GuliUserMapper guliUserMapper;

    @PostMapping("/userLogin")
    @ResponseBody
    @Override
    public GuliUser login(String userName, String userPassword) {
        GuliUser guliUser = guliUserMapper.selectOne(new QueryWrapper<GuliUser>().eq("user_name", userName).eq("user_password", userPassword));
        return guliUser;
    }

}
