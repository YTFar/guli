package com.guli.api;

import com.guli.pojo.GuliActivitie;
import com.guli.response.ObjectResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api(value="课程活动表管理接口",description = "课程活动管理接口，提供课程活动的增、删、改、查")
public interface GuliActivitieControllerApi {

    @ApiOperation("查询全部目录完成")
    @ApiIgnore
    public List<GuliActivitie> findAllActivitie();

}