package com.guli.api;

import com.guli.response.ObjectResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Api(value="课程管理接口",description = "课程管理接口，提供课程的增、删、改、查")
public interface GuliCourseControllerApi {

    @ApiOperation("查询全部课程")
    @ApiIgnore
    public ObjectResult getAllCourse();

}
