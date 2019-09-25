package com.guli.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guli.api.GuliUserControllerApi;
import com.guli.mapper.GuliUserDiscountMapper;
import com.guli.mapper.GuliUserMapper;
import com.guli.pojo.GuliUser;
import com.guli.pojo.ordervo.GuliDiscountVo;
import com.guli.pojo.ordervo.GuliOrderAndCourseVo;
import com.guli.service.GuliUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * ?û?? 前端控制器
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@RestController
@RequestMapping("/guliUser")
public class GuliUserController implements GuliUserControllerApi {

    @Autowired
    private GuliUserMapper guliUserMapper;

    @Autowired
    private GuliUserDiscountMapper guliUserDiscountMapper;

    @Autowired
    private GuliUserService guliUserService;

    @PostMapping("/login")
    @Override
    public GuliUser login(@RequestParam("userName") String userName,@RequestParam("passWord") String passWord) {
        GuliUser guliUser = guliUserMapper.selectOne(new QueryWrapper<GuliUser>().eq("user_name", userName).eq("user_password", passWord));
        return guliUser;
    }

    @PostMapping("/register")
    @Override
    public int register(@RequestBody GuliUser guliUser) {
        guliUser.setUserName(guliUser.getUserName());
        guliUser.setUserPassword(guliUser.getUserPassword());
        guliUser.setUserPhone(guliUser.getUserPhone());
        guliUser.setUserEmail(guliUser.getUserEmail());
        guliUser.setUserIamge("null");
        guliUser.setUserAuth(0);
        int insert = guliUserMapper.insert(guliUser);
        return insert;
    }

    @PostMapping("/checkName")
    @Override
    public int checkName(String userName) {
        Integer user_name = guliUserMapper.selectCount(new QueryWrapper<GuliUser>().eq("user_name", userName));
        return user_name;
    }

    @PostMapping("/updateUserInfo")
    @Override
    public int updateUserInfo(@RequestBody GuliUser guliUser) {
        System.out.println(guliUser);
        guliUser.setUserRealName(guliUser.getUserRealName());
        guliUser.setUserActor(guliUser.getUserActor());
        guliUser.setUserSex(guliUser.getUserSex());
        guliUser.setUserBrief(guliUser.getUserBrief());
        guliUser.setUserIntroduce(guliUser.getUserIntroduce());
        guliUser.setUserCompany(guliUser.getUserCompany());
        guliUser.setUserProfession(guliUser.getUserProfession());
        guliUser.setUserPersonalSpace(guliUser.getUserPersonalSpace());
        guliUser.setUserMicroblog(guliUser.getUserMicroblog());
        guliUser.setUserQQ(guliUser.getUserQQ());
        guliUser.setUserWeChat(guliUser.getUserWeChat());
        int update = guliUserMapper.updateById(guliUser);

        return update;
    }

    @PostMapping("/findUserById")
    @Override
    public GuliUser findUserById(int userId) {
        GuliUser guliUser = guliUserMapper.selectById(userId);

        return guliUser;
    }


    @GetMapping("/findAllOrder")
    @Override
    public List<GuliOrderAndCourseVo> findAllOrder(int userId) {
        List<GuliOrderAndCourseVo> allOrder = guliUserMapper.findAllOrder(userId);
        return allOrder;
    }

    @GetMapping("/findAllRefundOrder")
    @Override
    public List<GuliOrderAndCourseVo> findAllRefundOrder(int userId) {
        List<GuliOrderAndCourseVo> allRefundOrder = guliUserMapper.findAllRefundOrder(userId);
        return allRefundOrder;
    }

    @GetMapping("/searchVague")
    @Override
    public List<GuliOrderAndCourseVo> searchVague(int userId,String searchName) {
        List<GuliOrderAndCourseVo> guliOrderAndCourseVos = guliUserMapper.searchVague(userId,searchName);
        return guliOrderAndCourseVos;
    }

    @GetMapping("/findAllUserDiscount")
    @Override
    public List<GuliDiscountVo> findAllUserDiscount(int userId){
        List<GuliDiscountVo> allUserDiscount = guliUserDiscountMapper.findAllUserDiscount(userId);
        return allUserDiscount;

    }

    @GetMapping("/findAllUserCardUseAble")
    @Override
    public List<GuliDiscountVo> findAllUserCardUseAble(int userId) {
            List<GuliDiscountVo> allUserCardUseAble = guliUserDiscountMapper.findAllUserCardUseAble(userId);
            return allUserCardUseAble;

    }

    @GetMapping("/findAllUserCardUsed")
    @Override
    public List<GuliDiscountVo> findAllUserCardUsed(int userId) {
        List<GuliDiscountVo> allUserCardUsed = guliUserDiscountMapper.findAllUserCardUsed(userId);
        return allUserCardUsed;
    }

    @GetMapping("/findAllUserCardOutDate")
    @Override
    public List<GuliDiscountVo> findAllUserCardOutDate(int userId){
        List<GuliDiscountVo> allUserCardOutDate = guliUserDiscountMapper.findAllUserCardOutDate(userId);
        return allUserCardOutDate;
    }


}
