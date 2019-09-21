package com.guli.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.api.GuliCourseControllerApi;
import com.guli.mapper.GuliCourseMapper;
import com.guli.pojo.GuliCourse;
import com.guli.pojo.coursevo.CourseAndClassify;
import com.guli.pojo.coursevo.CourseAndClassifyAndUser;
import com.guli.pojo.request.PageCourse;
import com.guli.pojo.response.AllTypePage;
import com.guli.service.GuliCourseService;
import com.guli.vo.CourseVO;
import com.guli.vo.GuliEvaluateVO;
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

//    @Override
//    public IPage<GuliCourse> findPageAllCourse() {
//        return null;
//    }

    /**
     * 查询全部课程,并进行分页
     * @return
     */
    @GetMapping("/findPageAllCourse")
    public AllTypePage<GuliCourse> findPageAllCourse(@RequestParam("pageNo")int pageNo,@RequestParam("pageSize")int pageSize){
        IPage<GuliCourse> guliCourseIPage = guliCourseMapper.selectPage(new Page<GuliCourse>(pageNo, pageSize), null);
        AllTypePage<GuliCourse> allTypePage = new AllTypePage<>();
        //写自己传入的页码
        allTypePage.setPageNo(pageNo);
        //写入自己的显示数据量
        allTypePage.setPageSize(pageSize);
        //调用查询出分页对象的总页数
        allTypePage.setPageTotal((int)guliCourseIPage.getTotal());
        //调用查询出分页对象当前显示数据
        allTypePage.setPageList(guliCourseIPage.getRecords());
        return allTypePage;
    }

    /**
     * 根据二级分类id查询下面的课程
     * @param id
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    @GetMapping("/findPageAllCourseById")
    public AllTypePage<GuliCourse> findPageAllCourseById(@RequestParam("id") int id,@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize) {
        IPage<GuliCourse> guliCourseIPage = guliCourseMapper.selectPage(new Page<GuliCourse>(pageNo, pageSize),new QueryWrapper<GuliCourse>().inSql("classify_id","SELECT classify_id FROM guli_classify WHERE parent_id = "+id ));
        AllTypePage<GuliCourse> allTypePage = new AllTypePage<>();
        //写自己传入的页码
        allTypePage.setPageNo(pageNo);
        //写入自己的显示数据量
        allTypePage.setPageSize(pageSize);
        //调用查询出分页对象的总页数
        allTypePage.setPageTotal((int)guliCourseIPage.getTotal());
        //调用查询出分页对象当前显示数据
        allTypePage.setPageList(guliCourseIPage.getRecords());
        return allTypePage;
    }

    /**
     * 根据二级分类id查询下面的单个课程
     * @param id
     * @return
     */
    @GetMapping("/findCourseById")
    public List<GuliCourse> findCourseById(@RequestParam("id") int id){
        List<GuliCourse> list = guliCourseMapper.selectList(new QueryWrapper<GuliCourse>().eq("classify_id", id));
        return list;
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

    /**
     *  按老师id与课程名称的模糊查询分页信息
     * @param pageNo 第几页
     * @param pageSize 数据量
     * @param userId 教师id
     * @param courseName 课程名称
     * @return 返回分页课程信息
     * */
    @Override
    @GetMapping("/findAllPageCourse")
    public AllTypePage<GuliCourse> findAllPageCourse(@RequestParam("pageNo") int pageNo,@RequestParam("pageSize")  int pageSize,@RequestParam("userId")  int userId,@RequestParam("courseName")  String courseName) {
        if(courseName.equals("*")){
            courseName = "";
        }
        IPage<GuliCourse> guliCourseIPage = guliCourseMapper.selectPage(new Page<GuliCourse>(pageNo,pageSize), new QueryWrapper<GuliCourse>().inSql("course_id", "select course_id from guli_item where user_id = " + userId).like("course_name",courseName));
//        IPage<GuliCourse> guliCourseIPage = guliCourseService.findAllPageCourse(new Page<GuliCourse>(pageCourse.getPageNo(),pageCourse.getPageSize()),pageCourse);
        AllTypePage<GuliCourse> allTypePage = new AllTypePage<>();
        //写自己传入的页码
        allTypePage.setPageNo(pageNo);
        //写入自己的显示数据量
        allTypePage.setPageSize(pageSize);
        //调用查询出分页对象的总页数
        allTypePage.setPageTotal((int)guliCourseIPage.getTotal());
        //调用查询出分页对象当前显示数据
        allTypePage.setPageList(guliCourseIPage.getRecords());
        return allTypePage;
    }

    /**
     * 按课程id查询指定课程信息
     * @param id 课程id
     * @return 一个课程信息
     */
    @Override
    @GetMapping("/findCourseIdOneCourse")
    public CourseAndClassify findCourseIdOneCourse(@RequestParam("id") int id) {
        CourseAndClassify courseAndClassify = guliCourseMapper.findCourseIdOneCourse(id);
//        return  guliCourseMapper.selectOne(new QueryWrapper<GuliCourse>().eq("course_id", id));
        return courseAndClassify;
    }

    /**
     * 按id修改指定课程信息
     * @param guliCourse
     * @return
     */
    @Override
    @PutMapping("/pudateCourseIdOneCourse")
    public int pudateCourseIdOneCourse(@RequestBody GuliCourse guliCourse) {
       return guliCourseService.updateCourseIdCourse(guliCourse);
    }

    /**
     * 查询图片存储地址
     * @param courseId
     * @return 图片储存地址
     */
    @Override
    @GetMapping("/findCourseImg")
    public String findCourseImg(@RequestParam("courseId") Long courseId) {
        return guliCourseMapper.selectOne(new QueryWrapper<GuliCourse>().eq("course_id",courseId)).getCourseImage();
    }

    /**
     * 按id查询课程详情
     * @param courseId
     * @return 课程详情
     */
    @Override
    @GetMapping("/findByCourseId")
    public CourseAndClassifyAndUser findByCourseId(@RequestParam("courseId") int courseId) {
        return guliCourseService.findByCourseId(courseId);
    }

    /**
     * 课程信息 + 打折
     * 根据课程id查询课程
     * @return
     */
    @Override
    @GetMapping("/findByIdCourse")
    public CourseVO findByIdCourse(@RequestParam("id") int id) {
        return guliCourseMapper.findByIdCourse(id);
    }

    /**
     * 根据课程id查询课程名称
     * @param id
     * @return
     */
    @Override
    @GetMapping("/findByIdCourseName")
    public String findByIdCourseName(int id) {
        return guliCourseMapper.selectById(id).getCourseName();
    }

    /**
     * 根据用户id查询学习中的个数
     * @param id
     * @return
     */
    @Override
    @GetMapping("/findCountCourseById")
    public List<GuliCourse> findCountCourseById(int id) {
        return guliCourseMapper.findCountCourseById(id);
    }

    /**
     * 根据课程id查询该课程下面的目录个数
     * @param id
     * @return
     */
    @GetMapping("/findCountById")
    public int findCountById(@RequestParam("id") int id){
        return guliCourseMapper.findCountById(id);
    }

    @GetMapping("/findCourseCount")
    public int findCourseCount(@RequestParam("uid") int uid,@RequestParam("id") int id){
        return guliCourseMapper.findCourseCount(uid,id);
    }
}
