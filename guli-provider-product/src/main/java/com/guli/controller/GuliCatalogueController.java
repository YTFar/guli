package com.guli.controller;


import com.guli.api.GuliClassifyControllerApi;
import com.guli.pojo.GuliClassify;
import com.guli.response.ObjectResult;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * ?γ?Ŀ¼? 前端控制器
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@Controller
@RequestMapping("/guliCatalogue")
public class GuliCatalogueController implements GuliClassifyControllerApi{

    @Override
    public List<GuliClassify> findAllClassify() {
        return null;
    }

    @Override
    public List<GuliClassify> findTwoClassify(int id) {
        return null;
    }
}
