package com.guli.controller;


import com.guli.message.response.CommonCode;
import com.guli.pojo.GuliActivitie;
import com.guli.response.ObjectResult;
import com.guli.service.GuliActivitieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            Date date1 = null;
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
            return new ObjectResult(CommonCode.FAIL,"此活动已存在或正在进行中");
        }
        guliActivitie.setActivitieState(1);
        int count = guliActivitieService.addActivitie(guliActivitie);
        if (count < 1){
            return new ObjectResult(CommonCode.FAIL,"添加失败");
        }
        return new ObjectResult(CommonCode.SUCCESS,"添加成功");
    }

}
