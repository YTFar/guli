package com.guli.controller;


import com.guli.message.response.CommonCode;
import com.guli.response.ObjectResult;
import com.guli.service.GuliConcecrnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
public class GuliConcernController {

    @Autowired
    GuliConcecrnService guliConcecrnService;

    /**
     * 分页查询粉丝信息
     * @param pageNo 当前页
     * @param pageSize 数据量
     * @param userId 被关注人id
     * @param userName 粉丝名称(模糊查询)
     * @return 分页粉丝信息
     */
    @GetMapping("/findPageConcern")
    public ObjectResult findPageConcern(@RequestParam("pageNo") int pageNo,
                                        @RequestParam("pageSize")int pageSize,
                                        @RequestParam("userId")int userId,
                                        @RequestParam("concernName")String userName){
        return new ObjectResult(CommonCode.SUCCESS,guliConcecrnService.findPageConcern(pageNo,pageSize,userId,userName));
    }

    /**
     *  分页查询关注信息
     * @param pageNo 当前页
     * @param pageSize 数据量
     * @param userId 关注人id
     * @param userName 被关注人名称(模糊查询)
     * @return 分页关注信息
     */
    @GetMapping("/findPageTowConcern")
    public ObjectResult findPageTowConcern(@RequestParam("pageNo") int pageNo,
                                                          @RequestParam("pageSize")int pageSize,
                                                          @RequestParam("userId")int userId,
                                                          @RequestParam("concernName")String userName){
        return new ObjectResult(CommonCode.SUCCESS,guliConcecrnService.findPageTowConcern(pageNo,pageSize,userId,userName));
    }
}
