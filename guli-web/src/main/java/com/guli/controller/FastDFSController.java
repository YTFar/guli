package com.guli.controller;

import com.guli.service.FastDFSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 齐天大圣
 * @date 2019/9/5 20:48
 * @package com.guli.controller
 */
@RestController
@RequestMapping("/FastDFS")
public class FastDFSController {

    @Autowired
    FastDFSService fastDFSService;

    @PostMapping("/uploadPictures")
    public Map uploadPictures(@RequestPart(value = "multipartFile") MultipartFile multipartFile){
        Map<String,Object> map = new HashMap<>();
        if(multipartFile == null){
            map.put("code",1);
            return map;
        }
        String fileId = fastDFSService.uploadPictures(multipartFile);
        if(fileId == null){
            map.put("code",1);
            return map;
        }
        map.put("code",0);
        map.put("src",fileId);
        return map;
    }
}

