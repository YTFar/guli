package com.guli.api;

import com.guli.pojo.GuliSubdirectory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@Api(value="课程子目录管理接口",description = "课程子目录管理接口，提供课程分类的增、删、改、查")
public interface GuliSubdirectoryControllerApi {

    @ApiOperation("根据目录id查询课程子目录")
    public List<GuliSubdirectory> findByIdSubdirectory(int id);

}
