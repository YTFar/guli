package com.guli.controller;


import com.guli.message.response.CommonCode;
import com.guli.pojo.GuliActivitie;
import com.guli.pojo.GuliPower;
import com.guli.pojo.activitievo.ActivitieAndCourse;
import com.guli.pojo.response.AllTypePage;
import com.guli.response.ObjectResult;
import com.guli.service.GuliActivitieService;
import com.guli.service.GuliPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * ?? 前端控制器
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@RestController
@RequestMapping("/guliActivitie")
public class GuliActivitieController {

    @Autowired
    GuliActivitieService guliActivitieService;

    @Autowired
    GuliPowerService guliPowerService;

    /**
     * 添加课程活动
     * 1.判断时间是否为空为空则是永久打折不为空则是限时打折
     * 2.如果是限时打折取出时间字段与程序现在时间比对,如果大于继续向下,如果下于直接返回
     * 3.按课程id查询活动是否存在或活动,存在并活动直接返回,如果存在不活动和不存在继续向下
     * 4.判断是否添加成功
     * @param guliActivitie
     * @return 0 失败 1成功
     */
    @PostMapping("/addActivitie")
    public ObjectResult addActivitie(@RequestBody GuliActivitie guliActivitie) {
        if(!guliActivitie.getActivitieEndTime().equals("")){
            guliActivitie.setActivitieType("限时打折");
            Date date = new Date();
            SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date date1 = null;
            Date date2 = null;
            try {
//                date1 = format.parse(date);
                date2 = format.parse(guliActivitie.getActivitieEndTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
//            if(date2.before(date)){
//                new ObjectResult(CommonCode.FAIL,"活动结束日期不能小于当前日期");
//            }
//            System.out.println(date.compareTo(date2));
            if(date2.compareTo(date)<0){
                return new ObjectResult(CommonCode.FAIL,"活动结束日期不能小于当前日期");
            }
        }else{
            guliActivitie.setActivitieType("永久打折");
        }
        int isActivitie = guliActivitieService.findIsActivitie(guliActivitie.getCourseId());
        if(isActivitie > 0) {
            return new ObjectResult(CommonCode.FAIL,"此课程的活动已存在或正在进行中");
        }
        guliActivitie.setActivitieState(1);
        int count = guliActivitieService.addActivitie(guliActivitie);
        if (count < 1){
            return new ObjectResult(CommonCode.FAIL,"添加失败");
        }
        return new ObjectResult(CommonCode.SUCCESS,"添加成功");
    }

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
    @GetMapping("/findPageActivitie")
    public ObjectResult findPageActivitie(@RequestParam("pageNo") int pageNo,
                                          @RequestParam("pageSize") int pageSize,
                                          @RequestParam("userId") Long userId,
                                          @RequestParam("activitieType") String activitieType,
                                          @RequestParam("courseName") String courseName,
                                          @RequestParam("activitieState") int activitieState){
        GuliPower userIdPower = guliPowerService.findUserIdPower(userId);
        if(userIdPower.getPowerName().equals("管理员")){
            userId = -1l;
        }
        if(courseName.equals("")){
            courseName = "*";
        }
        if(activitieType.equals("")){
            activitieType = "*";
        }
        AllTypePage<ActivitieAndCourse> pageActivitie = guliActivitieService.findPageActivitie(pageNo, pageSize, userId, activitieType, courseName, activitieState);
        return new ObjectResult(CommonCode.DATASHOWSUCCESS,pageActivitie);
    }

    /**
     *  按活动id查询活动详情
     * @param activitieId
     * @return 课程详情信息
     */
    @GetMapping("/findActivitieIdActivitie")
    public ObjectResult findActivitieIdActivitie(@RequestParam("activitieId") int activitieId){
        ActivitieAndCourse activitieIdActivitie = guliActivitieService.findActivitieIdActivitie(activitieId);
        if(activitieIdActivitie == null){
            return new ObjectResult(CommonCode.FAIL,"查询失败!");
        }
        return new ObjectResult(CommonCode.SUCCESS,activitieIdActivitie);
    }

    /**
     * 按活动id修改指定活动信息
     * 1.判断此次修改有无意义 0 无意义返回提示信息 1 继续
     * 2.判断日期是否为空,如果不为空判断日期大于当前日期 小于 返回提示信息 大于 继续
     * 3.判断是否为成功 0失败返回提示信息 1成功返回提示信息
     * @param guliActivitie
     * @return
     */
    @PutMapping("/updateActivitieIdActivitie")
    public ObjectResult updateActivitieIdActivitie(@RequestBody GuliActivitie guliActivitie){
//        int isActivitieExcludeOneself = guliActivitieService.findIsActivitieExcludeOneself(guliActivitie.getActivitieId(), guliActivitie.getCourseId());
//        if(isActivitieExcludeOneself > 0){
//            new ObjectResult(CommonCode.FAIL,"此活动的课程已存在活动或进行中,此次活动无法跟新");
//        }
        if(guliActivitie.getActivitieState() != 1){
            return new ObjectResult(CommonCode.FAIL,"活动状态不是进行中,此次跟新无意义");
        }
        if(!guliActivitie.getActivitieEndTime().equals("")){
            Date date = new Date();
            SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date2 = null;
            try {
                date2 = format.parse(guliActivitie.getActivitieEndTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if(date2.compareTo(date)<0){
                return new ObjectResult(CommonCode.FAIL,"活动结束日期不能小于当前日期");
            }
        }
        int updateActivitieIdActivitie = guliActivitieService.updateActivitieIdActivitie(guliActivitie);
        if(updateActivitieIdActivitie < 1){
            return new ObjectResult(CommonCode.FAIL,"修改失败");
        }
        return new ObjectResult(CommonCode.SUCCESS,"修改成功");
    }

    /**
     * 判断课程id此活动是否存在或是否结束排除自己
     * @param activitieId 活动Id
     * @param courseId 课程Id
     * @return
     */
    @GetMapping("/findIsActivitieExcludeOneself")
    public ObjectResult findIsActivitieExcludeOneself(@RequestParam("activitieId") Long activitieId,@RequestParam("courseId") Long courseId){
//        System.out.println(123456);
        int isActivitieExcludeOneself = guliActivitieService.findIsActivitieExcludeOneself(activitieId, courseId);
//        int isActivitieExcludeOneself = guliActivitieService.findIsActivitieExcludeOneself1(activitieId, courseId);
        if(isActivitieExcludeOneself > 0){
            return new ObjectResult(CommonCode.FAIL,"此活动的课程已存在活动或进行中,此次操作无效");
        }
        return new ObjectResult(CommonCode.DATASHOWSUCCESS,null);
    }

}
