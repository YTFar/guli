package com.guli.api;

import com.guli.pojo.GuliCourse;
import com.guli.pojo.GuliEvaluate;
import com.guli.vo.CourseVO;
import com.guli.vo.GuliEvaluateVO;
import com.guli.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api(value="课程评价接口",description = "课程评价接口，提供课程的增、删、改、查")
public interface GuliEvaluateControllerApi {

    @ApiOperation("查询课程评价")
    @ApiIgnore
    public List<GuliEvaluateVO> findAllEvaluate();

    @ApiOperation("悬浮显示用户信息")
    UserVO findByIdUser(int id);

    @ApiOperation("根据id查询课程信息")
    CourseVO findByIdCourse(int id);
}
