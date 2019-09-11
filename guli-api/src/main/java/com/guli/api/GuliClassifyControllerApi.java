package com.guli.api;

import com.guli.pojo.GuliClassify;
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

}
