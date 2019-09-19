package com.guli.api;

import com.guli.pojo.GuliActivitie;
import com.guli.pojo.activitievo.ActivitieAndCourse;
import com.guli.pojo.response.AllTypePage;
import com.guli.response.ObjectResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api(value="课程活动表管理接口",description = "课程活动管理接口，提供课程活动的增、删、改、查")
public interface GuliActivitieControllerApi {

//    @ApiOperation("查询全部目录完成")
//    @ApiIgnore
//    public List<GuliActivitie> findAllActivitie();

    @ApiOperation("添加课程活动")
    public int addActivitie(GuliActivitie guliActivitie);

    @ApiOperation("判断课程id此活动是否存在或是否结束")
    public int findIsActivitie(Long courseId);

    @ApiOperation("按教师id分页查询课程信息")
    public AllTypePage<ActivitieAndCourse> findPageActivitie(int pageNo, int pageSize, Long userId, String activitieType, String courseName, int activitieState);

    @ApiOperation("按活动id与教师id查询活动详情")
    public ActivitieAndCourse findActivitieIdActivitie(int activitieId);

    @ApiOperation("按活动id修改指定活动信息")
    public int updateActivitieIdActivitie(GuliActivitie guliActivitie);

    @ApiOperation("判断课程id此活动是否存在或是否结束排除自己")
    public int findIsActivitieExcludeOneself(Long activitieId,Long courseId);

}
