package com.guli.controller;

import com.guli.pojo.GuliUser;
import com.guli.service.GuliUserService;
import com.guli.utils.Encryption;
import com.guli.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController extends BaseController {

    @Resource
    GuliUserService guliUserService;

    @PostMapping("/login")
    public String login(@RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword,HttpSession session) {
        Encryption encryption = new Encryption();
        String s = encryption.encryptionMD5(userPassword);
        GuliUser guliUser = guliUserService.login(userName, s);

        if(guliUser != null){
            session.setAttribute("user",guliUser);
            return  "index";
        } else {
            session.setAttribute("error","登录失败,用户名或密码错误!");
            return  "login";
        }
    }

    @GetMapping("/logOut")
    public String logOut(){
        session.removeAttribute("user");
        return "login";
    }
}
