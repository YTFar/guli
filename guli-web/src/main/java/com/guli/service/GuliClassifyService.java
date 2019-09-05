package com.guli.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guli.pojo.GuliClassify;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
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
@FeignClient("TEST-MYBATIS")
public interface GuliClassifyService {

//    @GetMapping("/dept/get/{id}")
//    public Dept get(@PathVariable("id") long id);

    //@GetMapping("/dept/list")
    //网关取的服务别名mydept
//    @GetMapping("/")
//    public List<Dept> list();

//    @PostMapping("/dept/add")
//    public boolean add(Dept dept);

    @RequestMapping(value = "/guliClassify/findAllClassify")
    IPage<GuliClassify> fenYe();

}
