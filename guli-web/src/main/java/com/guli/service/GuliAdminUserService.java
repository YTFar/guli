package com.guli.service;

import com.guli.pojo.GuliUser;
import com.guli.pojo.response.AllTypePage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("GULI-PROVIDER-USER")
public interface GuliAdminUserService {

//    @PostMapping("/guliUser/login")
//    GuliUser login(@Param("userName") String userName, @Param("pwd") String pwd);

    /**
     * 根据用户id查询后台用户的信息
     * @param userId 用户id
     * @return 用户信息
     */
    @GetMapping("/guliAdminUser/findUserIdOneUser")
    public GuliUser findUserIdOneUser(@RequestParam("userId") int userId) ;

    /**
     * 按教师id查询本老师下所有学员
     * @param pageNo 当前页
     * @param pageSize 数据量
     * @param userId 教师id
     * @param userName 用户名称
     * @return 学员分页信息
     */
    @GetMapping("/guliAdminUser/findMemberPage")
    public AllTypePage<GuliUser> findMemberPage(@RequestParam("pageNo") int pageNo,@RequestParam("pageSize") int pageSize,@RequestParam("userId") int userId,@RequestParam("userName") String userName);

    /**
     * 按id修改用户指定信息
     * @param guliUser 用户信息
     * @return
     */
    @PutMapping("/guliAdminUser/updateUser")
    public int updateUser(@RequestBody GuliUser guliUser);
}
