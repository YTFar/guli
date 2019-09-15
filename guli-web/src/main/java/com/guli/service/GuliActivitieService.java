package com.guli.service;

import com.guli.pojo.GuliActivitie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 齐天大圣
 * @date 2019/9/15 14:27
 * @package com.guli.service
 */
@FeignClient("GULI-PROVIDER-PRODUCT")
public interface GuliActivitieService {

    /**
     * 添加课程活动
     * @param guliActivitie
     * @return 0 失败 1成功
     */
    @PostMapping("/guliActivitie/addActivitie")
    public int addActivitie(@RequestBody GuliActivitie guliActivitie);

    /**
     * 判断课程id此活动是否存在或是否结束
     * @param courseId
     * @return 0 不存在或进行中 1存在或结束
     */
    @GetMapping("/guliActivitie/findIsActivitie")
    public int findIsActivitie(@RequestParam("courseId") Long courseId);
}
