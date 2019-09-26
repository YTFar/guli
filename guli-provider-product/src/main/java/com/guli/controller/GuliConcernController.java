package com.guli.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.api.GuliConcernControllerApi;
import com.guli.pojo.concernvo.ConcernAndUser;
import com.guli.pojo.response.AllTypePage;
import com.guli.service.GuliConcernService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * ??˿? 前端控制器
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@RestController
@RequestMapping("/guliConcern")
public class GuliConcernController implements GuliConcernControllerApi
{

    @Autowired
    GuliConcernService guliConcernService;

    /**
     * 分页查询粉丝信息
     * @param pageNo 当前页
     * @param pageSize 数据量
     * @param userId 被关注人id
     * @param userName 粉丝名称(模糊查询)
     * @return 分页粉丝信息
     */
    @Override
    @GetMapping("/findPageConcern")
    public AllTypePage<ConcernAndUser> findPageConcern(@RequestParam("pageNo") int pageNo,
                                                       @RequestParam("pageSize")int pageSize,
                                                       @RequestParam("userId")int userId,
                                                       @RequestParam("concernName")String userName) {
        if(userName.equals("*"))
            userName = "";
        Page<ConcernAndUser> page = new Page<>(pageNo,pageSize);
        page.setRecords(guliConcernService.findPageConcern(page,userId,userName));
        return pagePackaging(pageNo,pageSize,(int)page.getTotal(),page.getRecords());
    }

    /**
     *  分页查询关注信息
     * @param pageNo 当前页
     * @param pageSize 数据量
     * @param userId 关注人id
     * @param userName 被关注人名称(模糊查询)
     * @return 分页关注信息
     */
    @Override
    @GetMapping("/findPageTowConcern")
    public AllTypePage<ConcernAndUser> findPageTowConcern(@RequestParam("pageNo") int pageNo,
                                                          @RequestParam("pageSize")int pageSize,
                                                          @RequestParam("userId")int userId,
                                                          @RequestParam("concernName")String userName) {
        if(userName.equals("*"))
            userName = "";
        Page<ConcernAndUser> page = new Page<>(pageNo,pageSize);
        page.setRecords(guliConcernService.findPageTowConcern(page,userId,userName));
        return pagePackaging(pageNo,pageSize,(int)page.getTotal(),page.getRecords());
    }

    /**
     * 按id删除指定粉丝与关注信息
     * @param concernId
     * @return
     */
    @Override
    @Delete("/deleteConcern")
    public int deleteConcern(int concernId) {
        return guliConcernService.deleteConcern(concernId);
    }


    private AllTypePage<ConcernAndUser> pagePackaging(int pageNo, int pageSize, int pageTotal, List<ConcernAndUser> pageRecords){
        AllTypePage<ConcernAndUser> allTypePage = new AllTypePage<ConcernAndUser>();
        allTypePage.setPageNo(pageNo);
        allTypePage.setPageSize(pageSize);
        allTypePage.setPageTotal(pageTotal);
        allTypePage.setPageList(pageRecords);
        return allTypePage;
    }
}
