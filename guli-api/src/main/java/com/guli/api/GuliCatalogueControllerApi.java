package com.guli.api;

import com.guli.pojo.GuliCatalogue;
import com.guli.pojo.cataloguevo.CatalogueAndAccomplish;
import com.guli.pojo.cataloguevo.CatalogueAndCourse;
import com.guli.pojo.response.AllTypePage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@Api(value="课程目录管理接口",description = "课程目录管理接口，提供课程分类的增、删、改、查")
public interface GuliCatalogueControllerApi {

    @ApiOperation("根据课程id查询目录")
    List<GuliCatalogue> findByIdCatalogue(int id);

    @ApiOperation("添加课程目录")
    int addCatalogue(GuliCatalogue guliCatalogue);

    @ApiOperation("查询目录名称是否存在")
    int findIsCatalogueName(String name);

    @ApiOperation("按id修改目录信息")
    int updateCatalogue(GuliCatalogue guliCatalogue);

//    @ApiOperation("根据课程id分页查询目录信息")
//    AllTypePage<CatalogueAndAccomplish> findAllPageCatalogue(int pageNo,int pageSize ,Long userId,Long courseId,String catalogueName);

    @ApiOperation("按条件分页查询目录信息")
    public AllTypePage<CatalogueAndCourse> findAllPageCatalogue (int pageNo,int pageSize,Long courseId,String catalogueName);

}
