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

    @GetMapping(value = "/guliClassify/findAllClassify")
    List<GuliClassify> findAllClassify();

    /**
     * 查询二级课程分类
     * @return
     */
    @GetMapping("/findAllClassify")
    public List<GuliClassify> findTwoClassify(@RequestParam("id") int id);

}
