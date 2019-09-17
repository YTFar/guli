package com.guli.api;

import com.guli.pojo.GuliCatalogue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@Api(value="课程目录管理接口",description = "课程目录管理接口，提供课程分类的增、删、改、查")
public interface GuliCatalogueControllerApi {

    @ApiOperation("根据课程id查询目录")
    List<GuliCatalogue> findByIdCatalogue(int id);

}
