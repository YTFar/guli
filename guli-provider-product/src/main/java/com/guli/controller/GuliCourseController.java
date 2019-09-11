package com.guli.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.api.GuliCourseControllerApi;
import com.guli.mapper.GuliCourseMapper;
import com.guli.pojo.GuliCourse;
import com.guli.service.GuliCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

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
    public List<GuliCourse> findAllCourse() {
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


    @Override
    public List<GuliCourse> findRatingCourse() {
        return null;
    }

    /**
     * 根据二级分类id查询课程信息"
     * @param id
     * @return
     */
    @Override
    @GetMapping("/findCourse")
    public List<GuliCourse> findCourse(@RequestParam("id") int id) {
        List<GuliCourse> list = guliCourseMapper.selectList(new QueryWrapper<GuliCourse>().eq("classify_id",id));
        return list;
    }

    /**
     * 根据一级分类查课程信息
     * @param id
     * @return
     */
    @GetMapping("/findOneCourse")
    @Override
    public List<GuliCourse> findOneCourse(@RequestParam("id") int id) {
       List<GuliCourse> list = guliCourseMapper.findOneCourse(id);
        return list;
    }

    /**
     * 根据星评查询推荐信息
     * @return
     */
    @GetMapping("/findRecommendCourse")
    @Override
    public List<GuliCourse>findRecommendCourse(){
        List<GuliCourse> list = guliCourseMapper.findRecommendCourse();
        System.out.println("推荐课程："+list.toString());
        return list;
    }

    /**
     * 查询全部课程,可按......进行判断并进行分页
     * @return
     */
    @GetMapping("/findPageAllCourse")
    public IPage<GuliCourse> findPageAllCourse(){
        IPage<GuliCourse> page = guliCourseMapper.selectPage(new Page<GuliCourse>(1, 20), null);
        return page;
    }

    /**
     * 判断课程名是否存在
     * @param courseName
     * @return true = 不存在, false = 存在
     */
    @Override
    @GetMapping("/isCourseName")
    public boolean isCourseName(@RequestParam("courseName") String courseName) {
        Integer count = guliCourseMapper.selectCount(new QueryWrapper<GuliCourse>().eq("course_name", courseName));
//        System.out.println(count);
        return count <= 0 ? true : false;
    }

    /**
     * 课程添加
     * 1.添加项表把老师id保存其中,并返回自己项id
     * 2.添加课程信息(包括图片地址、项id等),返回课程id
     * 3.跟新项表,把课程id跟新从0跟新成刚添加的课程id
     * @param guliCourse
     * @return 失败返回null,成功返回自己的对象信息
     */
    @Override
    @PostMapping("/addCourse")
    public GuliCourse addCourse(@RequestBody GuliCourse guliCourse) {
        GuliCourse course = guliCourseService.addCourse(guliCourse);
        return course;
    }

    @Override
    public List<GuliCourse> findAllCourse(int pageNo, int pageSize, String CourseId) {

        return null;
    }

}
