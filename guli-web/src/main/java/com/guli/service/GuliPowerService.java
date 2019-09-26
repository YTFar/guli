package com.guli.service;

import com.guli.pojo.GuliPower;
import com.guli.pojo.response.AllTypePage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 齐天大圣
 * @date 2019/9/18 10:16
 * @package com.guli.service
 */
@FeignClient("GULI-PROVIDER-PRODUCT")
public interface GuliPowerService {


    /**
     * 查询权限
     * @param userId
     * @return 权限信息
     */
    @GetMapping("/guliPower/findUserIdPower")
    public GuliPower findUserIdPower(@RequestParam("userId") Long userId);

    /**
     * 分页查询所有权限信息
     * @param pageNo 当前页
     * @param pageSize 数据量
     * @param powerName 权限
     * @return 分页权限信息
     */
    @GetMapping("/guliPower/findPageGuliPower")
    public AllTypePage<GuliPower> findPageGuliPower(@RequestParam("pageNo") int pageNo,
                                                    @RequestParam("pageSize")  int pageSize,
                                                    @RequestParam("powerName")  String powerName);

    /**
     * 按id修改权限信息
     * @param guliPower 权限信息
     * @return 0 失败 1 成功
     */
    @PutMapping("/guliPower/updatePower")
    public int updatePower(@RequestBody GuliPower guliPower);
}
