package com.guli.api;

import com.guli.response.ObjectResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Api(value="目录完成管理接口",description = "目录完成管理接口，提供目录完成的增、删、改、查")
public interface GuliAccomplishControllerApi {

    @ApiOperation("查询全部目录完成")
    @ApiIgnore
    public ObjectResult findAllAccomplish();

}
