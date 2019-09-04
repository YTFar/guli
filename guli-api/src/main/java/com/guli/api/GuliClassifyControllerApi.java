package com.guli.api;

import com.guli.pojo.GuliUser;
import com.guli.response.ObjectResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api(value="课程分类管理接口",description = "课程分类管理接口，提供课程分类的增、删、改、查")
public interface GuliClassifyControllerApi {

    @ApiOperation("查询全部课程分类")
    @ApiIgnore
    public ObjectResult findAllClassify();

}
