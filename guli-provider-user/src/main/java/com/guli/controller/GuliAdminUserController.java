package com.guli.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.api.GuliAdminUserControllerApi;
import com.guli.mapper.GuliAdminUserMapper;
import com.guli.pojo.GuliUser;
import com.guli.pojo.response.AllTypePage;
import com.guli.service.GuliAdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * ?û?? 前端控制器
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@RestController
@RequestMapping("/guliAdminUser")
public class GuliAdminUserController implements GuliAdminUserControllerApi {

//    @Autowired
//    private GuliUserService guliUserService;

    @Autowired
    GuliAdminUserMapper guliAdminUserMapper;

    @Autowired
    GuliAdminUserService guliAdminUserService;

//    @GetMapping("/login/{userName}/{pwd}")
//    @Override
//    public GuliUser login(@PathVariable("userName") String userName, @PathVariable("pwd") String pwd) {
//        GuliUser guliUser = guliUserMapper.selectOne(new QueryWrapper<GuliUser>().eq("user_name", userName).eq("user_password", pwd));
//        return guliUser;
//    }

    /**
     * 根据用户id查询后台用户的信息
     * @param userId 用户id
     * @return 用户信息
     */
    @Override
    @GetMapping("/findUserIdOneUser")
    public GuliUser findUserIdOneUser(@RequestParam("userId") int userId) {
        return guliAdminUserMapper.selectOne(new QueryWrapper<GuliUser>().eq("user_id",userId));
//        return null;
    }

    /**
     * 按教师id查询本老师下所有学员
     * @param pageNo 当前页
     * @param pageSize 数据量
     * @param userId 教师id
     * @param userName 用户名称
     * @return 学员分页信息
     */
    @Override
    @GetMapping("/findMemberPage")
    public AllTypePage<GuliUser> findMemberPage(@RequestParam("pageNo") int pageNo,@RequestParam("pageSize") int pageSize,@RequestParam("userId") int userId,@RequestParam("userName") String userName) {
        if(userName.equals("*"))
            userName = "";
        Page<GuliUser> page = new Page<>(pageNo,pageSize);
        page.setRecords(guliAdminUserService.findMemberPage(page,userId,userName));
        AllTypePage<GuliUser> allTypePage = new AllTypePage<GuliUser>();
        //写自己传入的页码
        allTypePage.setPageNo(pageNo);
        //写入自己的显示数据量
        allTypePage.setPageSize(pageSize);
        //调用查询出分页对象的总页数
        allTypePage.setPageTotal((int)page.getTotal());
        //调用查询出分页对象当前显示数据
        allTypePage.setPageList(page.getRecords());
        return allTypePage;
    }

    /**
     * 按id修改用户指定信息
     * @param guliUser 用户信息
     * @return
     */
    @Override
    @PutMapping("/updateUser")
    public int updateUser(@RequestBody GuliUser guliUser) {
        return guliAdminUserService.updateUser(guliUser);
    }
}
