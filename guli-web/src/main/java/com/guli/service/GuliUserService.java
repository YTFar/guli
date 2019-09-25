package com.guli.service;

import com.guli.pojo.GuliUser;
import com.guli.pojo.ordervo.GuliDiscountVo;
import com.guli.pojo.ordervo.GuliOrderAndCourseVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(value = "GULI-PROVIDER-USER")
public interface GuliUserService {

    //  登陆
    @PostMapping("/login/userLogin")
    GuliUser login(@RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword);

    //  注册
    @PostMapping("/guliUser/register")
    int register(@RequestBody GuliUser guliUser);

    //  检查用户名是否存在
    @PostMapping("/guliUser/checkName")
    int checkName(@RequestParam("userName") String name);

    //  修改后台个人用户信息
    @PostMapping("/guliUser/updateUserInfo")
    int updateUserInfo(@RequestBody GuliUser guliUser);

    //  根据id查询个人用户信息
    @PostMapping("/guliUser/findUserById")
    GuliUser findUserById(@RequestParam("userId") int userId);

    //  根据id查询个人订单信息
    @GetMapping("/guliUser/findAllOrder")
    List<GuliOrderAndCourseVo> findAllOrder(@RequestParam("userId") int userId);

    //  根据id查询个人退款订单管理信息
    @GetMapping("/guliUser/findAllRefundOrder")
    List<GuliOrderAndCourseVo> findAllRefundOrder(@RequestParam("userId") int userId);

    //  根据课程名称进行模糊查询
    @GetMapping("/guliUser/searchVague")
    List<GuliOrderAndCourseVo> searchName(@RequestParam("userId") int userId, @RequestParam("searchName") String searchName);

    //  根据用户id查询该用户所有优惠卷信息
    @GetMapping("/guliUser/findAllUserDiscount")
    List<GuliDiscountVo> findAllUserDiscount(@RequestParam("userId") int userId);

    @GetMapping("/guliUser/findAllUserCardUseAble")
    List<GuliDiscountVo> findAllUserCardUseAble(@RequestParam("userId") int userId);

    @GetMapping("/guliUser/findAllUserCardUsed")
    List<GuliDiscountVo> findAllUserCardUsed(@RequestParam("userId") int userId);

    @GetMapping("/guliUser/findAllUserCardOutDate")
    List<GuliDiscountVo> findAllUserCardOutDate(@RequestParam("userId") int userId);


}
