package com.guli.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.api.GuliUserControllerApi;
import com.guli.pojo.GuliClassify;
import com.guli.pojo.GuliUser;
import com.guli.service.GuliClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/guliClassify")
public class GuliClassifyController implements GuliUserControllerApi {

    @Autowired
    GuliClassifyService guliClassifyService;

    @RequestMapping(value = "/findAllClassify")
    public String hello() {
        IPage<GuliClassify> guliClassifyIPage = guliClassifyService.fenYe();
        return "";
    }

//    @Override
//    @GetMapping("/list")
//    public List<GuliUser> guliUserList() {
//        List<GuliUser> list = new ArrayList<>();
//        GuliUser guliUser = new GuliUser();
//        guliUser.setUserName("哈哈");
//        guliUser.setUserAuth(1);
//        guliUser.setUserEmail("1962267412@qq.com");
//        guliUser.setUserIamge("123.png");
//        guliUser.setUserPassword("123");
//        guliUser.setUserId(1l);
//        guliUser.setUserPhone("13873575256");
//        GuliUser guliUser2 = new GuliUser();
//        guliUser2.setUserName("积极");
//        guliUser2.setUserAuth(1);
//        guliUser2.setUserEmail("1962267412@qq.com");
//        guliUser2.setUserIamge("123.png");
//        guliUser2.setUserPassword("123");
//        guliUser2.setUserId(1l);
//        guliUser2.setUserPhone("13873575256");
//        GuliUser guliUser3 = new GuliUser();
//        guliUser3.setUserName("试试");
//        guliUser3.setUserAuth(1);
//        guliUser3.setUserEmail("1962267412@qq.com");
//        guliUser3.setUserIamge("123.png");
//        guliUser3.setUserPassword("123");
//        guliUser3.setUserId(1l);
//        guliUser3.setUserPhone("13873575256");
//        list.add(guliUser);
//        list.add(guliUser2);
//        list.add(guliUser3);
//        return list;
//    }
}
