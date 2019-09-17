package com.guli.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.guli.message.response.CommonCode;
import com.guli.pojo.GuliCourse;
import com.guli.pojo.coursevo.CourseAndClassify;
import com.guli.pojo.coursevo.CourseAndClassifyAndUser;
import com.guli.pojo.request.PageCourse;
import com.guli.pojo.response.AllTypePage;
import com.guli.response.ObjectResult;
import com.guli.service.GuliCourseService;
import com.guli.service.fastdfs.FastDFSService;
import com.guli.vo.CourseVO;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * ?γ̱ 前端控制器
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@RestController
@RequestMapping("/guliCourse")
public class GuliCourseController {

    @Autowired
    GuliCourseService guliCourseService;

    @Autowired
    FastDFSService fastDFSService;

    @GetMapping("/findAll")
    public ObjectResult findAllCourse() {
        return null;
    }

    /**
     * 首页查询热门课程
     */
    @GetMapping("/findWatched")
    public ObjectResult findWatchedCourse() {
        List<GuliCourse> watchedCourse = guliCourseService.findWatchedCourse();
        return new ObjectResult(CommonCode.SUCCESS,watchedCourse);
    }

    /**
     * 首页查询最新课程
     * @return
     */
    @GetMapping("/findNew")
    public ObjectResult findNewCourse(){
        List<GuliCourse> newCourse = guliCourseService.findNewCourse();
        return new ObjectResult(CommonCode.SUCCESS,newCourse);
    }


    /**
     * 根据二级分类id查询课程信息"
     * @param id
     * @return
     */
    @GetMapping("/findCourse")
    public ObjectResult findCourse(@RequestParam("id") int id) {
        List<GuliCourse> list = guliCourseService.findCourse(id);
        return new ObjectResult(CommonCode.SUCCESS,list);
    }

    /**
     * 根据一级分类id查课程
     * @param id
     * @return
     */
    @GetMapping("/findOneCourse")
    public ObjectResult findOneCourse(@RequestParam("id") int id){
        List<GuliCourse> list = guliCourseService.findOneCourse(id);
        return new ObjectResult(CommonCode.SUCCESS,list);
    }

    /**
     * 根据星评查询推荐课程
     * @return
     */
    @GetMapping("/findRecommendCourse")
    public ObjectResult findRecommendCourse(){
        List<GuliCourse> list = guliCourseService.findRecommendCourse();
        return  new ObjectResult(CommonCode.SUCCESS,list);
    }

    /**
     * 查询全部课程进行分页
     * @return
     */
    @GetMapping("/findPageAllCourse")
    public ObjectResult findPageAllCourse(@RequestParam("pageNo")int pageNo,@RequestParam("pageSize")int pageSize){
        AllTypePage<GuliCourse> page = guliCourseService.findPageAllCourse(pageNo,pageSize);
        return new ObjectResult(CommonCode.SUCCESS,page);
    }

    /**
     * 根据二级分类id查询课程分页
     * @param id
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/findPageAllCourseById")
    public ObjectResult findPageAllCourseById(@RequestParam("id")int id,@RequestParam("pageNo")int pageNo,@RequestParam("pageSize")int pageSize){
        AllTypePage<GuliCourse> page = guliCourseService.findPageAllCourseById(id, pageNo, pageSize);
        return  new ObjectResult(CommonCode.SUCCESS,page);
    }

    /**
     * 根据 二级分类id查询下面单个课程
     * @param id
     * @return
     */
    @GetMapping("/findCourseById")
    public ObjectResult findCourseById(@RequestParam("id") int id){
        List<GuliCourse> list = guliCourseService.findCourseById(id);
        return new ObjectResult(CommonCode.SUCCESS,list);
    }

    /**
     * 查询课程名是否存在
     * @param courseName
     * @return
     */
    @GetMapping("/isCourseName")
    public ObjectResult isCourseName(@RequestParam("courseName") String courseName){
        boolean b = guliCourseService.isCourseName(courseName);
//        System.out.println(b);
        return new ObjectResult(CommonCode.SUCCESS,b);
    }

    /**
     * 添加课程
     * @param guliCourse
     * @return
     */
    @PostMapping("/addCourse")
    public ObjectResult addCourse(@RequestBody GuliCourse guliCourse) {
//        System.out.println(guliCourse);
        boolean courseName = guliCourseService.isCourseName(guliCourse.getCourseName());
        if(courseName == false){
            return new ObjectResult(CommonCode.FAIL,null);
        }
        return new ObjectResult(CommonCode.SUCCESS,guliCourseService.addCourse(guliCourse));
    }

    /**
     *  按老师id与课程名称的模糊查询分页信息
     * @param pageNo 第几页
     * @param pageSize 数据量
     * @param userId 教师id
     * @param courseName 课程名称
     * @return 返回分页课程信息
     */
    @GetMapping("/findAllPageCourse")
    public ObjectResult findAllPageCourse(@RequestParam("pageNo") int pageNo,@RequestParam("pageSize")  int pageSize,@RequestParam("userId")  int userId,@RequestParam("courseName")  String courseName){
        if(courseName == null|| courseName.equals("")){
            courseName = "*";
        }
        AllTypePage<GuliCourse> page = guliCourseService.findAllPageCourse(pageNo,pageSize,userId,courseName);
        if(page == null){
            return new ObjectResult(CommonCode.FAIL,null);
        }
        return new ObjectResult(CommonCode.SUCCESS,page);
    }

    /**
     * 按课程id查询指定课程信息
     * @param id 课程id
     * @return 一个课程信息
     */
    @GetMapping("/findCourseIdOneCourse")
    public ObjectResult findCourseIdOneCourse(@RequestParam("id") int id){
        CourseAndClassify courseAndClassify = guliCourseService.findCourseIdOneCourse(id);
        if(courseAndClassify == null){
            return new ObjectResult(CommonCode.FAIL,null);
        }
        return new ObjectResult(CommonCode.SUCCESS,courseAndClassify);
    }

    /**
     * 按id修改指定课程信息
     * 1.查询图片信息
     * 2.判断数据库与传入地址是否一致
     * 3.不一致删除文件系统中的图片,一致继续向下执行
     * 4.跟新数据库的课程信息
     * 5.判断是否跟新
     * @param guliCourse
     * @return 提示信息
     */
    @PutMapping("/pudateCourseIdOneCourse")
    public ObjectResult pudateCourseIdOneCourse(@RequestBody GuliCourse guliCourse){
        //1.查询图片信息
        String courseImg = guliCourseService.findCourseImg(guliCourse.getCourseId());
        //2.判断数据库与传入地址是否一致
        if(!courseImg.equals(guliCourse.getCourseImage())){
            //3.不一致删除文件系统中的图片,一致继续向下执行
            Integer integer = fastDFSService.delete_file(courseImg);
            if (integer < 0){
                System.out.println("删除失败");
                new ObjectResult(CommonCode.FAIL,"删除图片失败!");
            }else{
                System.out.println("删除成功");
            }
        }
        //4.跟新数据库的课程信息
        int count = guliCourseService.pudateCourseIdOneCourse(guliCourse);
        //5.判断是否跟新
        if(count < 1){
            new ObjectResult(CommonCode.FAIL,"修改失败!");
        }
        return new ObjectResult(CommonCode.SUCCESS,"修改成功!");
    }


    /**
     * 按id查询课程详情
     * @param courseId
     * @return 课程详情
     */
    @GetMapping("/findByCourseId")
    public ObjectResult findByCourseId(@RequestParam("courseId") int courseId){
        return new ObjectResult(CommonCode.SUCCESS,guliCourseService.findByCourseId(courseId));
    }

    /**
     * 课程信息 + 打折
     * 根据课程id查询课程
     * @return
     */
    @GetMapping("/findByIdCourse")
    public ObjectResult findByIdCourse(@RequestParam("id") int id){
        return new ObjectResult(CommonCode.SUCCESS,guliCourseService.findByIdCourse(id));
    }
}
