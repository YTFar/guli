package com.guli.controller;


import com.guli.message.response.CommonCode;
import com.guli.pojo.GuliEvaluate;
import com.guli.response.ObjectResult;
import com.guli.service.GuliEvaluateService;
import com.guli.vo.CourseVO;
import com.guli.vo.GuliEvaluateVO;
import com.guli.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * ???۱ 前端控制器
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@RestController
@RequestMapping("/guliEvaluate")
public class GuliEvaluateController {

    @Autowired
    private GuliEvaluateService guliEvaluateService;

    @GetMapping("/findAllEvaluate")
    public ObjectResult findAllEvaluate(){
        List<GuliEvaluateVO> list = guliEvaluateService.findAllEvaluate();
        ObjectResult objectResult = new ObjectResult(CommonCode.SUCCESS,list);
        return objectResult;
    }

    /**
     * 根据id查询课程信息
     * @param id
     * @return
     */
    @GetMapping("/findByIdCourse")
    public ObjectResult findByIdCourse(@RequestParam("id") int id){
        CourseVO byIdCourse = guliEvaluateService.findByIdCourse(id);
        ObjectResult objectResult = new ObjectResult(CommonCode.SUCCESS,byIdCourse);
        return objectResult;
    }

    /**
     * 悬浮显示用户信息
     * @param id
     * @return
     */
    @GetMapping("/findByIdUser")
    public ObjectResult findByIdUser(@RequestParam("id") int id){
        UserVO byIdUser = guliEvaluateService.findByIdUser(id);
        ObjectResult objectResult = new ObjectResult(CommonCode.SUCCESS,byIdUser);
        return objectResult;
    }

}
