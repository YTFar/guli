package com.guli.controller;


import com.guli.message.response.CommonCode;
import com.guli.pojo.GuliIntroduce;
import com.guli.pojo.GuliPower;
import com.guli.pojo.introducevo.IntroduceAndCourse;
import com.guli.pojo.response.AllTypePage;
import com.guli.response.ObjectResult;
import com.guli.service.GuliIntroduceService;
import com.guli.service.GuliPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * ?γ̽??ܱ 前端控制器
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@RestController
@RequestMapping("/guliIntroduce")
public class GuliIntroduceController {

    @Autowired
    GuliIntroduceService guliIntroduceService;

    @Autowired
    GuliPowerService guliPowerService;

    /**
     * 添加详情介绍信息
     * 1.查询课程是否存在,如果存在返回,不存在继续
     * 2.判断是否成功
     * @param guliIntroduce
     * @return 0 失败 1成功
     */
    @PostMapping("/addIntroduce")
    public ObjectResult addIntroduce(@RequestBody GuliIntroduce guliIntroduce){
        int isIntroduce = guliIntroduceService.findIsIntroduce(guliIntroduce.getCourseId());
        if(isIntroduce > 0){
            return new ObjectResult(CommonCode.FAIL,"此详情介绍信息已存在");
        }
        int introduce = guliIntroduceService.addIntroduce(guliIntroduce);
        if(introduce < 1){
            return new ObjectResult(CommonCode.FAIL,"添加失败");
        }
        return new ObjectResult(CommonCode.SUCCESS,"添加成功");
    }

    /**
     * 按条件分页查询详情介绍信息
     * @param pageNo 页数
     * @param pageSize 数据量
     * @param userId
     * @param courseName
     * @return
     */
    @GetMapping("/findAllPageIntroduce")
    public ObjectResult findAllPageIntroduce(@RequestParam("pageNo") int pageNo,
                                                                @RequestParam("pageSize") int pageSize,
                                                                @RequestParam("userId") Long userId,
                                                                @RequestParam("courseName") String courseName){
        GuliPower userIdPower = guliPowerService.findUserIdPower(userId);
        if(userIdPower.getPowerName().equals("管理员")){
            userId = -1l;
        }
        if(courseName.equals("")){
            courseName = "*";
        }
        return new ObjectResult(CommonCode.SUCCESS,guliIntroduceService.findAllPageIntroduce(pageNo,pageSize,userId,courseName));
    }

    /**
     * 按介绍id查询详情介绍信息
     * @param introduceId
     * @return
     */
    @GetMapping("/findOneIntroduce")
    public ObjectResult findOneIntroduce(@RequestParam("introduceId") int introduceId){
        return new ObjectResult(CommonCode.SUCCESS,guliIntroduceService.findOneIntroduce(introduceId));
    }

    /**
     * 按id修改指定介绍信息
     * @param guliIntroduce
     * @return
     */
    @PutMapping("/updateIntroduce")
    public ObjectResult updateIntroduce(@RequestBody GuliIntroduce guliIntroduce){
        int i = guliIntroduceService.updateIntroduce(guliIntroduce);
        if (i < 1){
            return new ObjectResult(CommonCode.SUCCESS,"修改失败");
        }
        return new ObjectResult(CommonCode.SUCCESS,"修改成功");
    }

}
