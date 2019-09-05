package com.guli.service;

import com.guli.pojo.GuliCourse;
import com.guli.response.ObjectResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient("GULI-PROVIDER-PRODUCT")
public interface GuliCourseService {

//    //注入工程客户端接口
//    @Autowired
//    GuliCourseClient guliCourseClient;

    @RequestMapping(value = "/guliCourse/findWatched")
    List<GuliCourse> findWatchedCourse();

    @RequestMapping(value = "/guliCourse/findNew")
    List<GuliCourse> findNewCourse();
}
