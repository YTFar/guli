package com.guli.controller;

import com.guli.message.response.CommonCode;
import com.guli.pojo.GuliUser;
import com.guli.response.ObjectResult;
import com.guli.service.GuliAdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guliAdminUser")
public class GuliAdminUserController {

    @Autowired
    GuliAdminUserService guliAdminUserService;

//    @PostMapping("/login")
//    public ObjectResult login(@PathVariable("userName") String userName, @PathVariable("pwd") String pwd) {
//        GuliUser guliUser = guliUserService.login(userName,pwd);
//        return new ObjectResult(CommonCode.SUCCESS,guliUser);
//    }

    /**
     * 根据用户id查询后台用户的信息
     * @param userId 用户id
     * @return 用户信息
     */
    @GetMapping("/findUserIdOneUser")
    public ObjectResult findUserIdOneUser(@RequestParam("userId")int userId) {
        return new ObjectResult(CommonCode.SUCCESS,guliAdminUserService.findUserIdOneUser(userId));
    }

    /**
     * 按教师id查询本老师下所有学员
     * @param pageNo 当前页
     * @param pageSize 数据量
     * @param userId 教师id
     * @param userName 用户名称
     * @return 学员分页信息
     */
    @GetMapping("/findMemberPage")
    public ObjectResult findMemberPage(@RequestParam("pageNo") int pageNo,@RequestParam("pageSize") int pageSize,@RequestParam("userId") int userId,@RequestParam("userName") String userName){
        return new ObjectResult(CommonCode.SUCCESS,guliAdminUserService.findMemberPage(pageNo,pageSize,userId,userName));
    }

    /**
     * 按id修改用户指定信息
     * @param guliUser 用户信息
     * @return
     */
    @PutMapping("/updateUser")
    public ObjectResult updateUser(@RequestBody GuliUser guliUser){
        int count = guliAdminUserService.updateUser(guliUser);
        if(count < 1){
            return new ObjectResult(CommonCode.FAIL,"修改失败!");
        }
        return new ObjectResult(CommonCode.SUCCESS,"修改成功!");
    }

}
