package com.guli.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.guli.pojo.GuliCourse;
import com.guli.pojo.coursevo.CourseAndClassify;
import com.guli.pojo.coursevo.CourseAndClassifyAndUser;
import com.guli.pojo.response.AllTypePage;
import com.guli.vo.CourseVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping(value = "/guliCourse/findOneCourse")
    List<GuliCourse> findOneCourse(@RequestParam("id") int id);

    /**
     * 根据星评查询推荐课程
     * @return
     */
    @GetMapping(value = "/guliCourse/findRecommendCourse")
    List<GuliCourse> findRecommendCourse();

    /**
     * 查询全部分页
     * @return
     */
    @GetMapping(value = "/guliCourse/findPageAllCourse")
    IPage<GuliCourse> findPageAllCourse();

    /**
     * 根据二级分类id查询课程信息"
     * @param id
     * @return
     */
    @GetMapping("/findCourse")
    public List<GuliCourse> findCourse(@RequestParam("id") int id);

    /**
     * 判断课程名称是否存在
     * @param courseName
     * @return
     */
    @GetMapping("/guliCourse/isCourseName")
    public boolean isCourseName(@RequestParam("courseName") String courseName);

    @PostMapping("/guliCourse/addCourse")
    public GuliCourse addCourse(@RequestBody GuliCourse guliCourse);

    /**
     *  按老师id与课程名称的模糊查询分页信息
     * @param pageNo 第几页
     * @param pageSize 数据量
     * @param userId 教师id
     * @param courseName 课程名称
     * @return 返回分页课程信息
     */
    @GetMapping("/guliCourse/findAllPageCourse")
    public AllTypePage<GuliCourse> findAllPageCourse(@RequestParam("pageNo") int pageNo,@RequestParam("pageSize")  int pageSize,@RequestParam("userId")  int userId,@RequestParam("courseName")  String courseName);

    /**
     * 按课程id查询指定课程信息
     * @param id 课程id
     * @return 一个课程信息
     */
    @GetMapping("/guliCourse/findCourseIdOneCourse")
    public CourseAndClassify findCourseIdOneCourse(@RequestParam("id") int id);

    /**
     *  按id修改指定课程信息
     * @param guliCourse
     * @return 是否成功
     */
    @PutMapping("/guliCourse/pudateCourseIdOneCourse")
    public int pudateCourseIdOneCourse(@RequestBody GuliCourse guliCourse);

    /**
     * 查询图片存储地址
     * @param courseId
     * @return 图片储存地址
     */
    @GetMapping("/guliCourse/findCourseImg")
    public String findCourseImg(@RequestParam("courseId") Long courseId);

    /**
     * 按id查询课程详情
     * @param courseId
     * @return 课程详情
     */
    @GetMapping("/guliCourse/findByCourseId")
    public CourseAndClassifyAndUser findByCourseId(@RequestParam("courseId") int courseId);

    /**
     * 根据课程id查询课程名称
     * @param id
     * @return
     */
    @GetMapping("/guliCourse/findByIdCourseName")
    String findByIdCourseName(@RequestParam("id")int id);

    /**
     * 课程信息 + 打折
     * 根据课程id查询课程
     * @return
     */
    @GetMapping("/guliCourse/findByIdCourse")
    public CourseVO findByIdCourse(@RequestParam("id") int id);

    /**
     * 查询所有课程分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/guliCourse/findPageAllCourse")
    public AllTypePage<GuliCourse> findPageAllCourse(@RequestParam("pageNo")int pageNo,@RequestParam("pageSize")int pageSize);

    /**
     * 根据二级分类id查询课程分页
     * @param id
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/guliCourse/findPageAllCourseById")
    public AllTypePage<GuliCourse> findPageAllCourseById(@RequestParam("id") int id,@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize);

    /**
     * 根据用户id查询学习中的课程个数
     * @param id
     * @return
     */
    @GetMapping("/guliCourse/findCountCourseById")
    public List<GuliCourse> findCountCourseById(@RequestParam("id") int id);

    /**
     * 根据课程id查询该课程下面的目录个数
     * @param id
     * @return
     */
    @GetMapping("/guliCourse/findCountById")
    public int findCountById(@RequestParam("id") int id);

    /**
     * 根据用户id和课程id查询该课程下完成了多少个目录
     * @param uid
     * @param id
     * @return
     */
    @GetMapping("/guliCourse/findCourseCount")
    public int findCourseCount(@RequestParam("uid") int uid,@RequestParam("id") int id);
}
