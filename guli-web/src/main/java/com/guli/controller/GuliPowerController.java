package com.guli.controller;


import com.guli.message.response.CommonCode;
import com.guli.pojo.GuliPower;
import com.guli.response.ObjectResult;
import com.guli.service.GuliPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * ?û?Ȩ? 前端控制器
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@RestController
@RequestMapping("/guliPower")
public class GuliPowerController {

    @Autowired
    GuliPowerService guliPowerService;

    /**
     * 分页查询所有权限信息
     * @param pageNo 当前页
     * @param pageSize 数据量
     * @param powerName 权限
     * @return 分页权限信息
     */
    @GetMapping("/findPageGuliPower")
    public ObjectResult findPageGuliPower(@RequestParam("pageNo") int pageNo,
                                          @RequestParam("pageSize") int pageSize,
                                          @RequestParam("powerName")  String powerName){
        return new ObjectResult(CommonCode.SUCCESS, guliPowerService.findPageGuliPower(pageNo,pageSize,powerName));
    }

    /**
     * 按id修改权限信息
     * @param guliPower 权限信息
     * @return 0 失败 1 成功
     */
    @PutMapping("/updatePower")
    public ObjectResult updatePower(@RequestBody GuliPower guliPower){
        int count = guliPowerService.updatePower(guliPower);
        if(count < 1){
            return new ObjectResult(CommonCode.FAIL,"修改失败");
        }
        return new ObjectResult(CommonCode.SUCCESS,"修改成功");
    }
}
