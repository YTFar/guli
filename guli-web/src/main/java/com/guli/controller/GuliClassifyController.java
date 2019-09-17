package com.guli.controller;

import com.guli.message.response.CommonCode;
import com.guli.pojo.GuliClassify;
import com.guli.pojo.GuliCourse;
import com.guli.response.ObjectResult;
import com.guli.service.GuliClassifyService;
import com.guli.service.GuliCourseService;
import com.guli.vo.ClassifyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guliClassify")
public class GuliClassifyController {

    @Autowired
    GuliClassifyService guliClassifyService;

    @Autowired
    GuliCourseService guliCourseService;

    /**
     * 查询父级分类课程
     * @param id
     * @return
     */
    @GetMapping(value = "/findAllClassify")
    public ObjectResult findAllClassify(@RequestParam("id") int id) {
        List<GuliClassify> list = guliClassifyService.findAllClassify(id);
        return new ObjectResult(CommonCode.SUCCESS,list);
    }

    /**
     * 查询二级分类课程
     * @param id
     * @return
     */
    @GetMapping(value = "/findTwoClassify")
    public ObjectResult findTwoClassify(@RequestParam("id") int id){
        List<GuliClassify> list = guliClassifyService.findTwoClassify(id);
        return  new ObjectResult(CommonCode.SUCCESS,list);
    }

    /**
     * 根据课程id查询课程分类
     * @return
     */
    @GetMapping("/findCourseTowClassify")
    public ObjectResult findCourseTowClassify(@RequestParam("id") int id) {
        GuliClassify b = guliClassifyService.findCourseTowClassify((long) id);
        GuliClassify a = guliClassifyService.findOneClassify(b.getParentId());
        ClassifyVO courseVO = new ClassifyVO();
        courseVO.setClassifyId(a.getClassifyId());
        courseVO.setClassifyTowId(id);
        courseVO.setClassifyName(a.getClassifyName());
        courseVO.setClassifyTowName(b.getClassifyName());
        String courseName = guliCourseService.findByIdCourseName(id);
        courseVO.setCourseName(courseName);
        return new ObjectResult(CommonCode.SUCCESS,courseVO);
    }

}
