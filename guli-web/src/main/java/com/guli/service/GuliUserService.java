package com.guli.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.pojo.GuliClassify;
import com.guli.pojo.GuliUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("GULI-PROVIDER-USER")
public interface GuliUserService {

    @PostMapping("/guliUser/login")
    GuliUser login(@Param("userName") String userName,@Param("pwd") String pwd);
}
