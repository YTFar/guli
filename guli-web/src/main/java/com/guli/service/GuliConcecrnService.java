package com.guli.service;

import com.guli.pojo.concernvo.ConcernAndUser;
import com.guli.pojo.response.AllTypePage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 齐天大圣
 * @date 2019/9/24 18:36
 * @package com.guli.service
 */
@FeignClient("GULI-PROVIDER-PRODUCT")
public interface GuliConcecrnService {

    /**
     * 分页查询粉丝信息
     * @param pageNo 当前页
     * @param pageSize 数据量
     * @param userId 被关注人id
     * @param userName 粉丝名称(模糊查询)
     * @return 分页粉丝信息
     */
    @GetMapping("/guliConcern/findPageConcern")
    public AllTypePage<ConcernAndUser> findPageConcern(@RequestParam("pageNo") int pageNo,
                                                       @RequestParam("pageSize")int pageSize,
                                                       @RequestParam("userId")int userId,
                                                       @RequestParam("concernName")String userName);

    /**
     *  分页查询关注信息
     * @param pageNo 当前页
     * @param pageSize 数据量
     * @param userId 关注人id
     * @param userName 被关注人名称(模糊查询)
     * @return 分页关注信息
     */
    @GetMapping("/guliConcern/findPageTowConcern")
    public AllTypePage<ConcernAndUser> findPageTowConcern(@RequestParam("pageNo") int pageNo,
                                                          @RequestParam("pageSize")int pageSize,
                                                          @RequestParam("userId")int userId,
                                                          @RequestParam("concernName")String userName);
}
