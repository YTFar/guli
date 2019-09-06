package com.guli.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.message.response.CommonCode;
import com.guli.response.ObjectResult;
import com.guli.product.service.GuliClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * ????? 前端控制器
 * </p>
 *
 * @author slz
 * @since 2019-09-02
 */
@Controller
@RequestMapping("/guliClassify")
public class GuliClassifyController {

    @Autowired
    private GuliClassifyService guliClassifyService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/getUser")
    public void contextLoads() {
        System.out.println("xxxx");
        System.out.println(guliClassifyService);
        IPage page = guliClassifyService.page(new Page(1, 2));
//        IPage page = guliClassifyService.fenYe(new Page(1, 2));
        long pages = page.getPages();
        long total = page.getTotal();
        long current = page.getCurrent();
        List list = page.getRecords();
        long size = page.getSize();
        System.out.println("pages:"+pages);
        System.out.println("total:"+total);
        System.out.println("current:"+current);
        System.out.println("size:"+size);
        for(Object o:list){
            System.out.println("oo:"+o);
        }
        System.out.println("*******************");
//        model.addAttribute("list",list);
        /*for (Student s:list) {
            System.out.println("s:"+s);
        }*/
    };

    @RequestMapping("/getUser3")
    public void test(){
        redisTemplate.opsForValue().append("msg","hello");
    }

    @GetMapping("/getUser2")
    @ResponseBody
    public ObjectResult contextLoads2() {
        System.out.println("xxxx");
        System.out.println(guliClassifyService);
        IPage page = guliClassifyService.fenYe(new Page(1, 2));
        long pages = page.getPages();
        long total = page.getTotal();
        long current = page.getCurrent();
        List list = page.getRecords();
        long size = page.getSize();
        System.out.println("pages:"+pages);
        System.out.println("total:"+total);
        System.out.println("current:"+current);
        System.out.println("size:"+size);
        for(Object o:list){
            System.out.println("oo:"+o);
        }
        System.out.println("*******************");
        System.out.println("*******************123213123");
//        model.addAttribute("list",list);
        /*for (Student s:list) {
            System.out.println("s:"+s);
        }*/
        return new ObjectResult(CommonCode.SUCCESS,page);
    };

    //测试分布式session
    @GetMapping("/User")
    public String getUser(HttpServletRequest request, HttpSession session){

        String name=(String)session.getAttribute("userName");
        if(name==null||name.isEmpty()){
            name="session:"+System.currentTimeMillis();
            session.setAttribute("userName",name);
        }
        System.out.println("访问的端口："+request.getServerPort()+":"+name);
        return name;
    }

}
