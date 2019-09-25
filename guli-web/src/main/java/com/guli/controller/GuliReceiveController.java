package com.guli.controller;


import com.guli.message.response.CommonCode;
import com.guli.pojo.ordervo.GuliDiscountVo;
import com.guli.response.ObjectResult;
import com.guli.service.GuliUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * ??ȡ?Żݱ 前端控制器
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@Controller
@RequestMapping("/guliReceive")
public class GuliReceiveController {

    @Resource
    GuliUserService guliUserService;

    @GetMapping("/findAllUserDiscount")
    @ResponseBody
    public ObjectResult findAllUserDiscount(@RequestParam("userId") int userId){
        List<GuliDiscountVo> allUserDiscount = guliUserService.findAllUserDiscount(userId);
        return new ObjectResult(CommonCode.FIND_ALL_USER_DISCOUNT_SUCCESS,allUserDiscount);
    }

    @GetMapping("/findAllUserCardUseAble")
    @ResponseBody
    public ObjectResult findAllUserCardUseAble(@RequestParam("userId") int userId){
        List<GuliDiscountVo> allUserCardUseAble = guliUserService.findAllUserCardUseAble(userId);
        return new ObjectResult(CommonCode.FIND_ALL_USER_CARD_USE_ABLE_SUCCESS,allUserCardUseAble);
    }

    @GetMapping("/findAllUserCardUsed")
    @ResponseBody
    public ObjectResult findAllUserCardUsed(@RequestParam("userId") int userId){
        List<GuliDiscountVo> allUserCardUsed = guliUserService.findAllUserCardUsed(userId);
        return new ObjectResult(CommonCode.FIND_ALL_USER_CARD_USED,allUserCardUsed);

    }

    @GetMapping("/findAllUserCardOutDate")
    @ResponseBody
    public ObjectResult findAllUserCardOutDate(@RequestParam("userId") int userId){
        List<GuliDiscountVo> allUserCardOutDate = guliUserService.findAllUserCardOutDate(userId);
        return new ObjectResult(CommonCode.FIND_ALL_USER_CARD_OUT_DATE_SUCCESS,allUserCardOutDate);
    }


}
