package com.guli.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guli.pojo.GuliUser;
import com.guli.response.ObjectResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 齐天大圣
 * @date 2019/9/3 14:41
 * @package com.guli.api
 */
@Api(value="用户管理接口",description = "用户管理接口，提供用户的增、删、改、查")
public interface GuliUserControllerApi {

    @ApiOperation("用户登陆")
    public GuliUser login(String userName,String pwd);

}
