package com.guli.service;

import com.guli.pojo.GuliCatalogue;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("GULI-PROVIDER-PRODUCT")
public interface GuliCatalogueService {

    /**
     * 根据课程id查询目录
     * @param id
     * @return
     */
    @GetMapping("/guliCatalogue/findByIdCatalogue")
    public List<GuliCatalogue> findByIdCatalogue(@RequestParam("id")int id);

}
