package com.guli.api;

import com.guli.pojo.GuliIntroduce;
import com.guli.pojo.introducevo.IntroduceAndCourse;
import com.guli.pojo.response.AllTypePage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Api(value="课程介绍接口",description = "课程介绍接口，提供课程的增、删、改、查")
public interface GuliIntroduceControllerApi {

    @ApiOperation("添加详情介绍信息")
    public int addIntroduce(GuliIntroduce guliIntroduce);

    @ApiOperation("按课程id查询此课程是否存在")
    public int findIsIntroduce(Long courseId);

    @ApiOperation("按条件分页查询详情介绍信息")
    public AllTypePage<IntroduceAndCourse> findAllPageIntroduce(int pageNo, int pageSize, Long userId, String courseName);

    @ApiOperation("按介绍id查询详情介绍信息")
    public IntroduceAndCourse findOneIntroduce(int introduceId);

    @ApiOperation("按id修改指定介绍信息")
    public int updateIntroduce(GuliIntroduce guliIntroduce);

}
