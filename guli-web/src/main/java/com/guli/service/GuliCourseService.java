package com.guli.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guli.pojo.GuliCourse;
import com.guli.response.ObjectResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient("GULI-PROVIDER-PRODUCT")
public interface GuliCourseService {

//    //注入工程客户端接口
//    @Autowired
//    GuliCourseClient guliCourseClient;

    @GetMapping(value = "/guliCourse/findWatched")
    List<GuliCourse> findWatchedCourse();

    @GetMapping(value = "/guliCourse/findNew")
    List<GuliCourse> findNewCourse();

    @GetMapping(value = "/guliCourse/findClassfiyCourse2")
    List<GuliCourse> findClassfiyCourse2(@RequestParam("parentId") int parentId);

    /**
     * 根据二级分类id查询课程信息"
     * @param id
     * @return
     */
    @GetMapping("/findCourse")
    public List<GuliCourse> findCourse(@RequestParam("id") int id);
}
