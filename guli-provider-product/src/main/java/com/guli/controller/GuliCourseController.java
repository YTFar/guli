package com.guli.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.guli.api.GuliCourseControllerApi;
import com.guli.mapper.GuliClassifyMapper;
import com.guli.mapper.GuliCourseMapper;
import com.guli.message.response.CommonCode;
import com.guli.pojo.GuliClassify;
import com.guli.pojo.GuliCourse;
import com.guli.response.ObjectResult;
import com.guli.service.GuliCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
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
public class GuliCourseController implements GuliCourseControllerApi {


    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private GuliCourseService guliCourseService;

    @Resource
    private GuliCourseMapper guliCourseMapper;


    @Override
    @GetMapping("/findAll")
    public ObjectResult findAllCourse() {
        return null;
    }

    /**
     * 首页查询最热课程(并存入了Redis中)
     * @return
     */
    @Override
    @GetMapping("/findWatched")
    @ResponseBody
    public List<GuliCourse> findWatchedCourse() {
//        //从缓存中查询当前对象
//        List<GuliCourse> list = (List<GuliCourse>)redisTemplate.opsForValue().get("Watched");
//        //没有取到
//        if(list == null){
//            //从数据库中查询
//            list = guliCourseMapper.selectList(new QueryWrapper<GuliCourse>().last("limit 10").orderByDesc("course_watched"));
//            //存到缓存当中
//            redisTemplate.opsForValue().set("Watched",list);
//        }
        List<GuliCourse> list = guliCourseMapper.selectList(new QueryWrapper<GuliCourse>().last("limit 10").orderByDesc("course_watched"));
        //System.out.println("最热课程："+list.toString());
        return list;
    }

    /**
     * 查询最新的课程（并存入Redis中）
     * @return
     */

    @GetMapping("/findNew")
    @ResponseBody
    public List<GuliCourse> findNewCourse(){
//        //从缓存中查询当前对象
//        List<GuliCourse> list2 = (List<GuliCourse>)redisTemplate.opsForValue().get("new");
//        //没有取到
//        if(list2==null){
//            //从数据库中查询
//            list2=guliCourseMapper.selectList(new QueryWrapper<GuliCourse>().last("limit 15").orderByDesc("course_create_time"));
//            //存到缓存当中
//            redisTemplate.opsForValue().set("new",list2);
//        }
        List<GuliCourse> list2 = guliCourseMapper.selectList(new QueryWrapper<GuliCourse>().last("limit 15").orderByDesc("course_create_time"));
        return list2;
    }

}
