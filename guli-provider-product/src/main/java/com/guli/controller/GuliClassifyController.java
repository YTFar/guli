package com.guli.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guli.api.GuliClassifyControllerApi;
import com.guli.mapper.GuliClassifyMapper;
import com.guli.pojo.GuliClassify;
import com.guli.pojo.classifyvo.ClassifyNode;
import com.guli.service.GuliClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * ????? 前端控制器
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@RestController
@RequestMapping("/guliClassify")
public class GuliClassifyController implements GuliClassifyControllerApi {

    @Resource
    private GuliClassifyMapper guliClassifyMapper;

    @Autowired
    private GuliClassifyService guliClassifyService;

    /**
     * 显示课程分类
     * @return
     */
    @GetMapping("/findAllClassify")
    @Override
    public List<GuliClassify> findAllClassify(@RequestParam("id") int id) {
        List<GuliClassify> list = guliClassifyMapper.selectList(
                new QueryWrapper<GuliClassify>().eq("parent_id",id)
        );
        System.out.println("数据："+list.toString());
        return list;
    }

    /**
     * 查询课程二级分类
     * @param id
     * @return
     */
    @GetMapping("/findTwoClassify")
    @Override
    public List<GuliClassify>findTwoClassify(@RequestParam("id") int id){
        List<GuliClassify> list = guliClassifyMapper.findTwoClassify(id);
        System.out.println("数据："+list.toString());
        return list;
    }

    /**
     * 课程显示页面
     * 根据课程id查询课程子分类
     * @param id
     * @return
     */
    @Override
    @GetMapping("/findCourseTowClassify")
    public GuliClassify findCourseTowClassify(@RequestParam("id") long id) {
        GuliClassify guliClassify = guliClassifyMapper.selectOne(
                new QueryWrapper<GuliClassify>().inSql("classify_id","SELECT classify_id FROM guli_course WHERE course_id ="+id)
        );
        return guliClassify;
    }

    /**
     * 课程显示页面
     * 根据子分类id查询课程父分类
     * @param id
     * @return
     */
    @Override
    @GetMapping("/findOneClassify")
    public GuliClassify findOneClassify(@RequestParam("id") Long id) {
        GuliClassify guliClassify = guliClassifyMapper.selectOne(
                new QueryWrapper<GuliClassify>().eq("classify_id",id)
        );
        return guliClassify;
    }

    /**
     * 查询所有分类
     * 1.查询出所有一级分类
     * 2.根据一级分类查询所有二级分类并储存于children中
     * @return
     */
    @Override
    @GetMapping("/findAllClassifyNode")
    public List<ClassifyNode> findAllClassifyNode() {
        return guliClassifyService.findAllClassifyNode();
    }

    /**
     * 添加分类
     * @param guliClassify
     * @return
     */
    @Override
    @PostMapping("/addClassify")
    public int addClassify(@RequestBody GuliClassify guliClassify) {
        return guliClassifyService.addClassify(guliClassify);
    }

    /**
     * 分类查询名称是否存在
     * @param classifyName
     * @return
     */
    @Override
    @GetMapping("/findIsClassifyName")
    public int findIsClassifyName(@RequestParam("classifyName") String classifyName) {
        return guliClassifyMapper.selectCount(new QueryWrapper<GuliClassify>().eq("classify_name",classifyName));
    }

    /**
     * 按id修改分类信息
     * @param guliClassify
     * @return
     */
    @Override
    @PutMapping("/updateClassify")
    public int updateClassify(@RequestBody GuliClassify guliClassify) {
        return guliClassifyService.updateClassify(guliClassify);
    }

    /**
     * 按id查询指定分类信息
     * @param classifyId
     * @return
     */
    @Override
    @GetMapping("/findClassifyId")
    public GuliClassify findClassifyId(@RequestParam("classifyId")Long classifyId) {
        return guliClassifyMapper.selectOne(new QueryWrapper<GuliClassify>().eq("classify_id",classifyId));
    }
}
