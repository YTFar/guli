package com.guli.api;

import com.guli.pojo.GuliUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "用户登录接口",description = "用户登录功能")
public interface LoginControllerApi {

    @ApiOperation("用户登录功能")
    GuliUser login(String userName,String userPassword);

}
