package com.guli.api;

import com.guli.pojo.GuliClassify;
import com.guli.pojo.classifyvo.ClassifyNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api(value="课程分类管理接口",description = "课程分类管理接口，提供课程分类的增、删、改、查")
public interface GuliClassifyControllerApi {

    @ApiOperation("查询课程分类")
    @ApiIgnore
    public List<GuliClassify> findAllClassify(int id);

    @ApiOperation("查询课程二级分类")
    @ApiIgnore
    public List<GuliClassify> findTwoClassify(int id);

    @ApiOperation("根据课程id查询课程子分类")
    public GuliClassify findCourseTowClassify(long id);

    @ApiOperation("根据子分类id查询课程父分类")
    public GuliClassify findOneClassify(Long id);

    @ApiOperation("查询所有分类")
    public List<ClassifyNode> findAllClassifyNode();

    @ApiOperation("添加分类")
    public int addClassify(GuliClassify guliClassify);

    @ApiOperation("分类查询名称是否存在")
    public int findIsClassifyName(String classifyName);

    @ApiOperation("按id修改分类信息")
    public int updateClassify(GuliClassify guliClassify);

    @ApiOperation("按id查询指定分类信息")
    public GuliClassify findClassifyId(Long classifyId);
}
