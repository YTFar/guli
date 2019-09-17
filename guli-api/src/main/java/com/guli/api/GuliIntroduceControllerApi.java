package com.guli.api;

import com.guli.pojo.GuliIntroduce;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Api(value="课程介绍接口",description = "课程介绍接口，提供课程的增、删、改、查")
public interface GuliIntroduceControllerApi {

    @ApiOperation("根据课程id查询课程评价")
    @ApiIgnore
    public GuliIntroduce findByIdIntroduce(int id);

}
