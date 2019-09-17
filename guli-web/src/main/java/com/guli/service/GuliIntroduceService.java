package com.guli.service;

import com.guli.pojo.GuliIntroduce;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("GULI-PROVIDER-PRODUCT")
public interface GuliIntroduceService {

    @GetMapping("/guliIntroduce/findByIdIntroduce")
    GuliIntroduce findByIdIntroduce(@RequestParam("id") int id);

}
