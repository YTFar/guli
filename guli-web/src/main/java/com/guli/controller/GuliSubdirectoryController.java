package com.guli.controller;


import com.guli.message.response.CommonCode;
import com.guli.response.ObjectResult;
import com.guli.service.GuliSubdirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * ??Ŀ¼? 前端控制器
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@RestController
@RequestMapping("/guliSubdirectory")
public class GuliSubdirectoryController {

    @Autowired
    GuliSubdirectoryService guliSubdirectoryService;

    /**
     * 根据目录id查询课程子目录
     * @param id
     * @return
     */
    @GetMapping("/findByIdSubdirectory")
    ObjectResult findByIdSubdirectory(@RequestParam("id")int id){
        return new ObjectResult(CommonCode.SUCCESS,guliSubdirectoryService.findByIdSubdirectory(id));
    }

}
