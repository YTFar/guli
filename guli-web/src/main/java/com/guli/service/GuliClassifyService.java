package com.guli.service;

import com.guli.pojo.GuliClassify;
import com.guli.pojo.classifyvo.classifyNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * ????? 服务类
 * </p>
 *
 * @author slz
 * @since 2019-09-02
 */
@FeignClient("GULI-PROVIDER-PRODUCT")
public interface GuliClassifyService {

    /**
     * 查询课程分类
     * @return
     */
    @GetMapping(value = "/guliClassify/findAllClassify")
    List<GuliClassify> findAllClassify(@RequestParam("id") int id);

    /**
     * 查询课程二级分类
     * @param id
     * @return
     */
    @GetMapping(value = "/guliClassify/findTwoClassify")
    List<GuliClassify> findTwoClassify(@RequestParam("id") int id);

    /**
     * 根据课程id查询课程子分类
     * @return
     */
    @GetMapping("/guliClassify/findCourseTowClassify")
    GuliClassify findCourseTowClassify(@RequestParam("id") Long id);

    /**
     *  根据子分类id查询课程父分类
     * @param id
     * @return
     */
    @GetMapping("/guliClassify/findOneClassify")
    GuliClassify findOneClassify(@RequestParam("id") Long id);

    /**
     * 查询所有分类
     * 1.查询出所有一级分类
     * 2.根据一级分类查询所有二级分类并储存于children中
     * @return
     */
    @GetMapping("/guliClassify/findAllClassifyNode")
    public List<classifyNode> findAllClassifyNode();

    /**
     * 添加分类
     * @param guliClassify
     * @return
     */
    @PostMapping("/guliClassify/addClassify")
    public int addClassify(@RequestBody GuliClassify guliClassify);

    /**
     * 分类查询名称是否存在
     * @param classifyName
     * @return
     */
    @GetMapping("/guliClassify/findIsClassifyName")
    public int findIsClassifyName(@RequestParam("classifyName") String classifyName);
}
