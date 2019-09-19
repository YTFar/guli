package com.guli.api;

import com.guli.pojo.GuliClassify;
import com.guli.pojo.classifyvo.classifyNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<classifyNode> findAllClassifyNode();

    @ApiOperation("添加分类")
    public int addClassify(GuliClassify guliClassify);

    @ApiOperation("分类查询名称是否存在")
    public int findIsClassifyName(String classifyName);
}
