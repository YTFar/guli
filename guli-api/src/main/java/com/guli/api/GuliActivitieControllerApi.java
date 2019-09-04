package com.guli.api;

import com.guli.response.ObjectResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Api(value="课程活动表管理接口",description = "课程活动管理接口，提供课程活动的增、删、改、查")
public interface GuliActivitieControllerApi {

    @ApiOperation("查询全部目录完成")
    @ApiIgnore
    public ObjectResult findAllActivitie();

}
