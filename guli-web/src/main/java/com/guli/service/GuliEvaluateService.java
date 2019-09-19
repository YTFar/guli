package com.guli.service;

import com.guli.pojo.GuliEvaluate;
import com.guli.vo.CourseVO;
import com.guli.vo.GuliEvaluateVO;
import com.guli.vo.UserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient("GULI-PROVIDER-PRODUCT")
public interface GuliEvaluateService {

    @GetMapping(value = "/guliEvaluate/findAllEvaluate")
    List<GuliEvaluateVO> findAllEvaluate();

    /**
     * 根据id查询课程信息
     * @param id
     * @return
     */
    @GetMapping("/guliEvaluate/findByIdCourse")
    public CourseVO findByIdCourse(@RequestParam("id") int id);

    /**
     * 悬浮显示用户信息
     * @param id
     * @return
     */
    @GetMapping("/guliEvaluate/findByIdUser")
    public UserVO findByIdUser(@RequestParam("id") int id);

    /**
     * 根据课程id 查询下面 加入的学员 显示20个
     * @param id
     * @return
     */
    @GetMapping("/guliEvaluate/findAllUsersById")
    public List<GuliEvaluateVO> findAllUsersById(@RequestParam("id") int id);


    /**
     * 根据用户id查询该用户在学的课程
     * @param id
     * @return
     */
    @GetMapping("/guliEvaluate/findUserCourseById")
    public List<GuliEvaluateVO> findUserCourseById(@RequestParam("id") int id);

    /**
     * 根据用户id查询该用户收藏的课程
     * @param id
     * @return
     */
    @GetMapping("/guliEvaluate/findUserCollectCourseById")
    public List<GuliEvaluateVO> findUserCollectCourseById(@RequestParam("id") int id);

    /**
     * 根据用户id查询粉丝详情
     * @param id
     * @return
     */
    @GetMapping("/guliEvaluate/findFansById")
    public List<GuliEvaluateVO> findFansById(@RequestParam("id") int id);


    /**
     * 根据用户id查询关注的用户
     * @param id
     * @return
     */
    @GetMapping("/guliEvaluate/findUserIdById")
    public List<GuliEvaluateVO> findUserIdById(@RequestParam("id") int id);
}
