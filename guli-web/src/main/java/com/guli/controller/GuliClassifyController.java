package com.guli.controller;

import com.guli.message.response.CommonCode;
import com.guli.pojo.GuliClassify;
import com.guli.response.ObjectResult;
import com.guli.service.GuliClassifyService;
import com.guli.service.GuliCourseService;
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

//    /**
//     * 根据课程id查询课程分类
//     * @return
//     */
//    @GetMapping("/findCourseTowClassify")
//    public ObjectResult findCourseTowClassify(@RequestParam("id") int id) {
//        GuliClassify b = guliClassifyService.findCourseTowClassify((long) id);
//        GuliClassify a = guliClassifyService.findOneClassify(b.getParentId());
//        ClassifyVO courseVO = new ClassifyVO();
//        courseVO.setClassifyId(a.getClassifyId());
//        courseVO.setClassifyTowId(id);
//        courseVO.setClassifyName(a.getClassifyName());
//        courseVO.setClassifyTowName(b.getClassifyName());
//        String courseName = guliCourseService.findByIdCourseName(id);
//        courseVO.setCourseName(courseName);
//        return new ObjectResult(CommonCode.SUCCESS,courseVO);
//    }

    /**
     * 查询所有分类
     * 1.查询出所有一级分类
     * 2.根据一级分类查询所有二级分类并储存于children中
     * @return
     */
    @GetMapping("/findAllClassifyNode")
    public ObjectResult findAllClassifyNode(){
        return new ObjectResult(CommonCode.SUCCESS,guliClassifyService.findAllClassifyNode());
    }


    /**
     * 添加分类
     * @param guliClassify
     * @return
     */
    @PostMapping("/addClassify")
    public ObjectResult addClassify(@RequestBody GuliClassify guliClassify){
        int isClassifyName = guliClassifyService.findIsClassifyName(guliClassify.getClassifyName());
        if(isClassifyName > 0){
            return new ObjectResult(CommonCode.FAIL,"此分类名称存在");
        }
        int i = guliClassifyService.addClassify(guliClassify);
        if(i < 1){
            return new ObjectResult(CommonCode.FAIL,"添加失败");
        }
        return new ObjectResult(CommonCode.SUCCESS,"添加成功");
    }

    /**
     * 分类查询名称是否存在
     * @param classifyName
     * @return
     */
    @GetMapping("/findIsClassifyName")
    public ObjectResult findIsClassifyName(@RequestParam("classifyName") String classifyName){
        int isClassifyName = guliClassifyService.findIsClassifyName(classifyName);
        if(isClassifyName > 0){
            return new ObjectResult(CommonCode.FAIL,"此分类存在");
        }
        return new ObjectResult(CommonCode.SUCCESS,"分类不存在");
    }

    /**
     * 按id修改分类信息
     * @param guliClassify
     * @return
     */
    @PutMapping("/updateClassify")
    public ObjectResult updateClassify(@RequestBody GuliClassify guliClassify){
        int isClassifyName = guliClassifyService.findIsClassifyName(guliClassify.getClassifyName());
        if(isClassifyName > 0){
            return new ObjectResult(CommonCode.FAIL,"此分类名称存在");
        }
        int i = guliClassifyService.updateClassify(guliClassify);
        if(i < 1){
            return new ObjectResult(CommonCode.FAIL,"修改失败");
        }
        return new ObjectResult(CommonCode.SUCCESS,"修改成功");
    }

    /**
     * 按id查询指定分类信息
     * @param classifyId
     * @return
     */
    @GetMapping("/findClassifyId")
    public ObjectResult findClassifyId(@RequestParam("classifyId") Long classifyId){
        return new ObjectResult(CommonCode.SUCCESS,guliClassifyService.findClassifyId(classifyId));
    }

}
