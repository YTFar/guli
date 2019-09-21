package com.guli.service;

import com.guli.pojo.GuliIntroduce;
import com.guli.pojo.introducevo.IntroduceAndCourse;
import com.guli.pojo.response.AllTypePage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author 齐天大圣
 * @date 2019/9/16 2:10
 * @package com.guli.service
 */
@FeignClient("GULI-PROVIDER-PRODUCT")
public interface GuliIntroduceService {

    /**
     * 添加详情介绍信息
     * @param guliIntroduce
     * @return 0 失败 1成功
     */
    @PostMapping("/guliIntroduce/addIntroduce")
    public int addIntroduce(@RequestBody GuliIntroduce guliIntroduce);

    /**
     * 按课程id查询此课程是否存在
     * @param courseId
     * @return 0 不存在 1 存在
     */
    @GetMapping("/guliIntroduce/findIsIntroduce")
    public int findIsIntroduce(@RequestParam("courseId") Long courseId);

    /**
     * 按条件分页查询详情介绍信息
     * @param pageNo 页数
     * @param pageSize 数据量
     * @param userId
     * @param courseName
     * @return
     */
    @GetMapping("/guliIntroduce/findAllPageIntroduce")
    public AllTypePage<IntroduceAndCourse> findAllPageIntroduce(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize, @RequestParam("userId") Long userId, @RequestParam("courseName") String courseName);

    /**
     * 按介绍id查询详情介绍信息
     * @param introduceId
     * @return
     */
    @GetMapping("/guliIntroduce/findOneIntroduce")
    public IntroduceAndCourse findOneIntroduce(@RequestParam("introduceId") int introduceId);

    /**
     * 按id修改指定介绍信息
     * @param guliIntroduce
     * @return
     */
    @PutMapping("/guliIntroduce/updateIntroduce")
    public int updateIntroduce(@RequestBody GuliIntroduce guliIntroduce);

}
