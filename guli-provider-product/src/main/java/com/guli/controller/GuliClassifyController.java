package com.guli.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guli.api.GuliClassifyControllerApi;
import com.guli.mapper.GuliClassifyMapper;
import com.guli.message.response.CommonCode;
import com.guli.pojo.GuliClassify;
import com.guli.response.ObjectResult;
import com.guli.service.GuliClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

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
@Controller
@RequestMapping("/guliClassify")
public class GuliClassifyController implements GuliClassifyControllerApi {

    @Resource
    private GuliClassifyMapper guliClassifyMapper;

    @RequestMapping("/findAllClassify")
    @Override
    public List<GuliClassify> findAllClassify() {
        List<GuliClassify> list = guliClassifyMapper.selectList(
                new QueryWrapper<GuliClassify>()
        );
        return list;
    }
}
