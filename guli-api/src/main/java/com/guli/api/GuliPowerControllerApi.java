package com.guli.api;

import com.guli.pojo.GuliPower;
import com.guli.pojo.response.AllTypePage;
import io.swagger.annotations.ApiOperation;

/**
 * @author 齐天大圣
 * @date 2019/9/18 10:06
 * @package com.guli.api
 */
public interface GuliPowerControllerApi {

    @ApiOperation("根据id查询用户权限")
    public GuliPower findUserIdPower(Long userId);

    @ApiOperation("分页查询所有权限信息")
    public AllTypePage<GuliPower> findPageGuliPower(int pageNo,int pageSize,String powerName);

    @ApiOperation("按id修改权限信息")
    public int updatePower(GuliPower guliPower);
}
