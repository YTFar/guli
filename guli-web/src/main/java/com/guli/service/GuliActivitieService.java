package com.guli.service;

import com.guli.pojo.GuliActivitie;
import com.guli.pojo.activitievo.ActivitieAndCourse;
import com.guli.pojo.response.AllTypePage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author 齐天大圣
 * @date 2019/9/15 14:27
 * @package com.guli.service
 */
@FeignClient("GULI-PROVIDER-PRODUCT")
public interface GuliActivitieService {

    /**
     * 添加课程活动
     * @param guliActivitie
     * @return 0 失败 1成功
     */
    @PostMapping("/guliActivitie/addActivitie")
    public int addActivitie(@RequestBody GuliActivitie guliActivitie);

    /**
     * 判断课程id此活动是否存在或是否结束
     * @param courseId
     * @return 0 不存在或进行中 1存在或结束
     */
    @GetMapping("/guliActivitie/findIsActivitie")
    public int findIsActivitie(@RequestParam("courseId") Long courseId);

    /**
     * 按id及其他条件分页查询出
     * @param pageNo 当前页数
     * @param pageSize 当前显示条数
     * @param userId 教师id
     * @param activitieType 折扣类型
     * @param courseName 课程名称 为空时以*来代替(传值不能为空)
     * @param activitieState 当前状态
     * @return 分页列表
     */
    @GetMapping("/guliActivitie/findPageActivitie")
    public AllTypePage<ActivitieAndCourse> findPageActivitie(@RequestParam("pageNo") int pageNo,
                                                             @RequestParam("pageSize") int pageSize,
                                                             @RequestParam("userId") Long userId,
                                                             @RequestParam("activitieType") String activitieType,
                                                             @RequestParam("courseName") String courseName,
                                                             @RequestParam("activitieState") int activitieState);

    /**
     *  按活动id查询活动详情
     * @param activitieId
     * @return 课程详情信息
     */
    @GetMapping("/guliActivitie/findActivitieIdActivitie")
    public ActivitieAndCourse findActivitieIdActivitie(@RequestParam("activitieId") int activitieId);

    /**
     * 按活动id修改指定活动
     * @param guliActivitie
     * @return
     */
    @PutMapping("/guliActivitie/updateActivitieIdActivitie")
    public int updateActivitieIdActivitie(@RequestBody GuliActivitie guliActivitie);

    /**
     * 判断课程id此活动是否存在或是否结束排除自己
     * @param activitieId 活动Id
     * @param courseId 课程Id
     * @return
     */
    @GetMapping("/guliActivitie/findIsActivitieExcludeOneself")
    public int findIsActivitieExcludeOneself(@RequestParam("activitieId") Long activitieId,@RequestParam("courseId") Long courseId);

}
