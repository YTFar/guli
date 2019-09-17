package com.guli.service;

import com.guli.pojo.GuliSubdirectory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("GULI-PROVIDER-PRODUCT")
public interface GuliSubdirectoryService {

    /**
     * 根据目录id查询课程子目录
     * @param id
     * @return
     */
    @GetMapping("/guliSubdirectory/findByIdSubdirectory")
    List<GuliSubdirectory> findByIdSubdirectory(@RequestParam("id")int id);
}
