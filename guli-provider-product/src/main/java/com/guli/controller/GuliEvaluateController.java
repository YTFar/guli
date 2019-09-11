package com.guli.controller;


import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.api.GuliEvaluateControllerApi;
import com.guli.mapper.GuliEvaluateMapper;
import com.guli.pojo.GuliEvaluate;
import com.guli.service.GuliEvaluateService;
import com.guli.vo.CourseVO;
import com.guli.vo.GuliEvaluateVO;
import com.guli.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * ???۱ 前端控制器
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@RestController
@RequestMapping("/guliEvaluate")
public class GuliEvaluateController implements GuliEvaluateControllerApi {

    @Autowired
    private GuliEvaluateService guliEvaluateService;

    @Autowired
    private GuliEvaluateMapper guliEvaluateMapper;

    @Override
    @GetMapping("/findAllEvaluate")
    public List<GuliEvaluateVO> findAllEvaluate(){
        return guliEvaluateMapper.findAllEvaluate();

//        Page<GuliEvaluateVO> page = new Page<>(1, 5);
//        List<GuliEvaluateVO> list = guliEvaluateService.pageJG(page,2);
//        page.setRecords(list);
//        System.out.println("----------------------------------------------------------------------");
//        System.out.println("----------------------------------------------------------------------");
//        System.out.println("----------------------------------------------------------------------");
//        long pages = page.getPages();
//        long total = page.getTotal();
//        long current = page.getCurrent();
//        long size = page.getSize();
//        System.out.println("pages:"+pages);
//        System.out.println("total:"+total);
//        System.out.println("current:"+current);
//        System.out.println("size:"+size);
//        for(Object o:list){
//            System.out.println("oo:"+o);
//        }
//        return list;
    }

    /**
     * 悬浮显示用户信息
     * @param id
     * @return
     */
    @Override
    @GetMapping("/findByIdUser")
    public UserVO findByIdUser(@RequestParam("id") int id) {
        return guliEvaluateMapper.findByIdUser(id);
    }

    /**
     * 根据id查询课程信息
     * @param id
     * @return
     */
    @Override
    @GetMapping("/findByIdCourse")
    public CourseVO findByIdCourse(@RequestParam("id") int id) {
        return guliEvaluateMapper.findByIdCourse(id);
    }
}
