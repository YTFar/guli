package com.guli.api;

import com.guli.pojo.GuliPower;
import io.swagger.annotations.ApiOperation;

/**
 * @author 齐天大圣
 * @date 2019/9/18 10:06
 * @package com.guli.api
 */
public interface GuliPowerControllerApi {

    @ApiOperation("根据id查询用户权限")
    public GuliPower findUserIdPower(Long userId);
}
