package com.guli.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class VideoController {

//    @RequestMapping("/")
//    public String page(){
//        return "video";
//    }

    @RequestMapping("/index")
    public String index(){
        System.out.println("1");
        return "index";
    }

    @PostMapping("upload")
    @ResponseBody
    public Boolean upload(MultipartFile file) {
        System.out.println(file.getName());
        File savefile = new File("D:\\",file.getOriginalFilename());
        try {
            file.transferTo(savefile);//将文件保存D盘下
        } catch (IOException e) {
            return false;
        }
        return true;
    }

}
