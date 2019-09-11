package com.guli.service;

import com.guli.vo.CourseVO;
import com.guli.vo.GuliEvaluateVO;
import com.guli.vo.UserVO;
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
}
