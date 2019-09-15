package com.guli.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.pojo.GuliClassify;
import com.guli.pojo.GuliCourse;
import com.guli.pojo.coursevo.CourseAndClassify;
import com.guli.pojo.coursevo.CourseAndClassifyAndUser;
import com.guli.pojo.request.PageCourse;
import com.guli.pojo.response.AllTypePage;
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

    @ApiOperation("根据二级分类id查询课程信息")
    @ApiIgnore
    public List<GuliCourse> findCourse(int id);

    @ApiOperation("根据一级分类id查询课程信息，首页显示")
    @ApiIgnore
    public List<GuliCourse> findOneCourse(int id);

    @ApiOperation("根据星评查询推荐课程信息，课程页显示")
    @ApiIgnore
    public List<GuliCourse> findRecommendCourse();

    @ApiOperation("查询所有课程分页，课程页显示")
    @ApiIgnore
    public IPage<GuliCourse> findPageAllCourse();

    @ApiOperation("查询课程名称是否存在")
    public boolean isCourseName(String courseName);

    @ApiOperation("添加课程")
    public GuliCourse addCourse(GuliCourse guliCourse);

    @ApiOperation("按老师id与课程名称的模糊查询分页信息")
    public AllTypePage<GuliCourse> findAllPageCourse(int pageNo,int pageSize,int userId,String courseName);

    @ApiOperation("按课程id查询指定课程信息")
    public CourseAndClassify findCourseIdOneCourse(int id);

    @ApiOperation("按id修改指定课程信息")
    public int pudateCourseIdOneCourse(GuliCourse guliCourse);

    @ApiOperation("按id查询数据库中的图片地址")
    public String findCourseImg(Long id);

    @ApiOperation("按id查询指定课程所有信息")
    public CourseAndClassifyAndUser findByCourseId(int courseId);
}
