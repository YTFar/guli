package com.guli.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guli.api.GuliClassifyControllerApi;
import com.guli.mapper.GuliClassifyMapper;
import com.guli.message.response.CommonCode;
import com.guli.pojo.GuliClassify;
import com.guli.response.ObjectResult;
import com.guli.service.GuliClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * ????? 前端控制器
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@RestController
@RequestMapping("/guliClassify")
public class GuliClassifyController implements GuliClassifyControllerApi {

    @Resource
    private GuliClassifyMapper guliClassifyMapper;

    /**
     * 显示课程分类
     * @return
     */
    @GetMapping("/findAllClassify")
    @Override
    public List<GuliClassify> findAllClassify() {
        List<GuliClassify> list = guliClassifyMapper.selectList(
                new QueryWrapper<GuliClassify>().eq("parent_id",0)
        );
        System.out.println("数据："+list.toString());
        return list;
    }

    /**
     * 查询二级课程分类
     * @return
     */
    @Override
    @GetMapping("/findTwoClassify")
    public List<GuliClassify> findTwoClassify(@RequestParam("id") int id) {
                List<GuliClassify> list = guliClassifyMapper.selectList(new QueryWrapper<GuliClassify>().eq("parent_id",id));
                System.out.println("二级分类id："+list.toString());
         return list;
    }
}
