package com.guli.service;

import com.guli.pojo.GuliCatalogue;
import com.guli.pojo.cataloguevo.CatalogueAndAccomplish;
import com.guli.pojo.cataloguevo.CatalogueAndCourse;
import com.guli.pojo.response.AllTypePage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("GULI-PROVIDER-PRODUCT")
public interface GuliCatalogueService {

    /**
     * 根据课程id查询目录
     * @param id
     * @return
     */
    @GetMapping("/guliCatalogue/findByIdCatalogue")
    public List<GuliCatalogue> findByIdCatalogue(@RequestParam("id")int id);

    /**
     * 添加课程目录
     * @param guliCatalogue
     * @return
     */
    @PostMapping("/guliCatalogue/addCatalogue")
    public int addCatalogue(@RequestBody GuliCatalogue guliCatalogue);

    /**
     * 查询此目录名称是否存在
     * @param catalogueName
     * @return
     */
    @GetMapping("/guliCatalogue/findIsCatalogueName")
    public int findIsCatalogueName(@RequestParam("catalogueName") String catalogueName);

    /**
     * 按id修改指定目录信息
     * @param guliCatalogue
     * @return
     */
    @PutMapping("/guliCatalogue/updateCatalogue")
    public int updateCatalogue(@RequestBody GuliCatalogue guliCatalogue);


    /**
     * 按条件分页查询目录信息
     * @param pageNo 当前页
     * @param pageSize 数据量
     * @param courseId 课程id
     * @param catalogueName 目录名称
     * @return
     */
    @GetMapping("/guliCatalogue/findAllPageCatalogue")
    public AllTypePage<CatalogueAndCourse> findAllPageCatalogue(@RequestParam("pageNo") int pageNo,
                                                                @RequestParam("pageSize")  int pageSize,
                                                                @RequestParam("courseId")  Long courseId,
                                                                @RequestParam("catalogueName")  String catalogueName);

//    /**
//     * 按条件分页查询课程目录信息
//     * @param pageNo 当前页
//     * @param pageSize 数据量
//     * @param userId 教师id
//     * @param courseId 课程id
//     * @param catalogueName 目录名称
//     * @return
//     */
//    @GetMapping("/guliCatalogue/findAllPageCatalogue")
//    public AllTypePage<CatalogueAndAccomplish> findAllPageCatalogue(@RequestParam("pageNo") int pageNo,
//                                                                    @RequestParam("pageSize") int pageSize,
//                                                                    @RequestParam("userId") Long userId,
//                                                                    @RequestParam("courseId") Long courseId,
//                                                                    @RequestParam("catalogueName") String catalogueName);
}
