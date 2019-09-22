package com.guli.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.api.GuliCatalogueControllerApi;
import com.guli.api.GuliClassifyControllerApi;
import com.guli.mapper.GuliCatalogueMapper;
import com.guli.pojo.GuliCatalogue;
import com.guli.pojo.GuliClassify;
import com.guli.pojo.activitievo.ActivitieAndCourse;
import com.guli.pojo.cataloguevo.CatalogueAndAccomplish;
import com.guli.pojo.cataloguevo.CatalogueAndCourse;
import com.guli.pojo.response.AllTypePage;
import com.guli.response.ObjectResult;
import com.guli.service.GuliCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RestController
@RequestMapping("/guliCatalogue")
public class GuliCatalogueController implements GuliCatalogueControllerApi {

    @Autowired
    private GuliCatalogueMapper guliCatalogueMapper;

    @Autowired
    private GuliCatalogueService guliCatalogueService;

    /**
     * 根据课程id查询目录
     * @param id
     * @return
     */
    @Override
    @GetMapping("/findByIdCatalogue")
    public List<GuliCatalogue> findByIdCatalogue(@RequestParam("id")int id) {
        return guliCatalogueMapper.selectList(
                new QueryWrapper<GuliCatalogue>().eq("course_id",id)
        );
    }

    /**
     * 添加课程目录
     * @param guliCatalogue
     * @return
     */
    @Override
    @PostMapping("/addCatalogue")
    public int addCatalogue(@RequestBody GuliCatalogue guliCatalogue) {
        return guliCatalogueService.addCatalogue(guliCatalogue);
    }

    /**
     * 查询此目录名称是否存在
     * @param catalogueName
     * @return
     */
    @Override
    @GetMapping("/findIsCatalogueName")
    public int findIsCatalogueName(@RequestParam("catalogueName") String catalogueName) {
        return guliCatalogueMapper.selectCount(new QueryWrapper<GuliCatalogue>().eq("catalogue_name",catalogueName));
    }

    /**
     * 按id修改指定目录信息
     * @param guliCatalogue
     * @return
     */
    @Override
    @PutMapping("/updateCatalogue")
    public int updateCatalogue(@RequestBody GuliCatalogue guliCatalogue) {
        return guliCatalogueService.updateCatalogue(guliCatalogue);
    }

    /**
     * 按条件分页查询目录信息
     * @param pageNo 当前页
     * @param pageSize 数据量
     * @param courseId 课程id
     * @param catalogueName 目录名称
     * @return
     */
    @Override
    @GetMapping("/findAllPageCatalogue")
    public AllTypePage<CatalogueAndCourse> findAllPageCatalogue(@RequestParam("pageNo") int pageNo,
                                                                @RequestParam("pageSize")  int pageSize,
                                                                @RequestParam("courseId")  Long courseId,
                                                                @RequestParam("catalogueName")  String catalogueName) {
        if(catalogueName.equals("*")){
            catalogueName = "";
        }
        Page<CatalogueAndCourse> page = new Page<CatalogueAndCourse>(pageNo,pageSize);
        page.setRecords(guliCatalogueService.findAllPageCatalogue(page,courseId,catalogueName));
        AllTypePage<CatalogueAndCourse> allTypePage = new AllTypePage<CatalogueAndCourse>();
        allTypePage.setPageNo(pageNo);
        allTypePage.setPageSize(pageSize);
        allTypePage.setPageTotal((int) page.getTotal());
        allTypePage.setPageList(page.getRecords());
        return allTypePage;
    }

//    /**
//     * 按条件分页查询课程目录信息
//     * @param pageNo 当前页
//     * @param pageSize 数据量
//     * @param userId 教师id
//     * @param courseId 课程id
//     * @param catalogueName 目录名称
//     * @return
//     */
//    @Override
//    @GetMapping("/findAllPageCatalogue")
//    public AllTypePage<CatalogueAndAccomplish> findAllPageCatalogue(@RequestParam("pageNo") int pageNo,
//                                                                    @RequestParam("pageSize") int pageSize,
//                                                                    @RequestParam("userId") Long userId,
//                                                                    @RequestParam("courseId") Long courseId,
//                                                                    @RequestParam("catalogueName") String catalogueName) {
//        if(catalogueName.equals("*")){
//            catalogueName = "";
//        }
//        Page<CatalogueAndAccomplish> page = new Page<>(pageNo,pageSize);
//        page.setRecords(guliCatalogueService.findAllPageCatalogue(page,userId,courseId,catalogueName));
//        AllTypePage<CatalogueAndAccomplish> allTypePage = new AllTypePage<CatalogueAndAccomplish>();
//        allTypePage.setPageNo(pageNo);
//        allTypePage.setPageSize(pageSize);
//        allTypePage.setPageTotal((int) page.getTotal());
//        allTypePage.setPageList(page.getRecords());
//        return allTypePage;
//    }
}
