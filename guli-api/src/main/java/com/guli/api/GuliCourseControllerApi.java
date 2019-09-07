package com.guli.api;

import com.guli.pojo.GuliClassify;
import com.guli.pojo.GuliCourse;
import com.guli.response.ObjectResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api(value="课程管理接口",description = "课程管理接口，提供课程的增、删、改、查")
public interface GuliCourseControllerApi {

    @ApiOperation("查询全部课程")
    @ApiIgnore
    public List<GuliCourse> findAllCourse();

    @ApiOperation("查询热门课程")
    @ApiIgnore
    public List<GuliCourse> findWatchedCourse();

    @ApiOperation("查询最新课程")
    @ApiIgnore
    public List<GuliCourse> findNewCourse();

    @ApiOperation("查询推荐课程")
    @ApiIgnore
    public List<GuliCourse> findRatingCourse();

//    @ApiOperation("查询课程分类")
//    @ApiIgnore
//    public List<GuliCourse> findClassfiyCourse();

//    @ApiOperation("查询二级id")
//    @ApiIgnore
//    public List<GuliClassify> findClassfiyId(int parentId);

    @ApiOperation("根据二级分类id查询课程信息")
    @ApiIgnore
    public List<GuliCourse> findCourse(int id);
}
