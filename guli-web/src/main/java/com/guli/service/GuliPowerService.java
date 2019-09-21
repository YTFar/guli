package com.guli.service;

import com.guli.pojo.GuliPower;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
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
}
