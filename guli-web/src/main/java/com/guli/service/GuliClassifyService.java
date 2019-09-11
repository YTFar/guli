package com.guli.service;

import com.guli.pojo.GuliClassify;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * ????? 服务类
 * </p>
 *
 * @author slz
 * @since 2019-09-02
 */
@FeignClient("GULI-PROVIDER-PRODUCT")
public interface GuliClassifyService {

    /**
     * 查询课程分类
     * @return
     */
    @GetMapping(value = "/guliClassify/findAllClassify")
    List<GuliClassify> findAllClassify(@RequestParam("id") int id);

    /**
     * 查询课程二级分类
     * @param id
     * @return
     */
    @GetMapping(value = "/guliClassify/findTwoClassify")
    List<GuliClassify> findTwoClassify(@RequestParam("id") int id);
}
