package com.guli.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.api.GuliPowerControllerApi;
import com.guli.mapper.GuliPowerMapper;
import com.guli.pojo.GuliPower;
import com.guli.pojo.response.AllTypePage;
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
public class GuliPowerController implements GuliPowerControllerApi {

    @Autowired
    GuliPowerMapper guliPowerMapper;

    @Autowired
    GuliPowerService guliPowerService;

    /**
     * 查询权限
     * @param userId
     * @return 权限信息
     */
    @Override
    @GetMapping("/findUserIdPower")
    public GuliPower findUserIdPower(@RequestParam("userId") Long userId) {
        return guliPowerMapper.selectOne(new QueryWrapper<GuliPower>().eq("user_id",userId));
    }

    /**
     * 分页查询所有权限信息
     * @param pageNo 当前页
     * @param pageSize 数据量
     * @param powerName 权限
     * @return 分页权限信息
     */
    @Override
    @GetMapping("/findPageGuliPower")
    public AllTypePage<GuliPower> findPageGuliPower(@RequestParam("pageNo") int pageNo,
                                                    @RequestParam("pageSize") int pageSize,
                                                    @RequestParam("powerName")  String powerName) {
        if(powerName.equals("*"))
            powerName = "";
        Page<GuliPower> page = new Page<>(pageNo,pageSize);
        page.setRecords(guliPowerService.findPageGuliPower(page,powerName));
        AllTypePage<GuliPower> allTypePage = new AllTypePage<GuliPower>();
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
     * 按id修改权限信息
     * @param guliPower 权限信息
     * @return 0 失败 1 成功
     */
    @Override
    @PutMapping("/updatePower")
    public int updatePower(@RequestBody GuliPower guliPower) {
        return guliPowerService.updatePower(guliPower);
    }
}
