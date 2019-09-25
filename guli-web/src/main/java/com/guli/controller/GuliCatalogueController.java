package com.guli.controller;


import com.guli.message.response.CommonCode;
import com.guli.pojo.GuliCatalogue;
import com.guli.response.ObjectResult;
import com.guli.service.GuliCatalogueService;
import com.guli.service.GuliPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class GuliCatalogueController{

    @Autowired
    private GuliCatalogueService guliCatalogueService;

    @Autowired
    private GuliPowerService guliPowerService;

    /**
     * 根据课程id查询课程目录
     * @param id
     * @return
     */
    @GetMapping("/findByIdCatalogue")
    public ObjectResult findByIdCatalogue(@RequestParam("courseId")int id){
        return new ObjectResult(CommonCode.SUCCESS,guliCatalogueService.findByIdCatalogue(id));
    }

    /**
     * 添加课程目录
     * @param guliCatalogue
     * @return
     */
    @PostMapping("/addCatalogue")
    public ObjectResult addCatalogue(@RequestBody GuliCatalogue guliCatalogue){
        int isCatalogueName = guliCatalogueService.findIsCatalogueName(guliCatalogue.getCatalogueName());
        if(isCatalogueName > 0){
            return new ObjectResult(CommonCode.FAIL,"目录名称不存在");
        }
        int i = guliCatalogueService.addCatalogue(guliCatalogue);
        if(i < 1){
            return new ObjectResult(CommonCode.FAIL,"添加失败");
        }
        return new ObjectResult(CommonCode.SUCCESS,"添加成功");
    }

    /**
     * 查询此目录名称是否存在
     * @param catalogueName
     * @return
     */
    @GetMapping("/findIsCatalogueName")
    public ObjectResult findIsCatalogueName(@RequestParam("catalogueName") String catalogueName){
        int isCatalogueName = guliCatalogueService.findIsCatalogueName(catalogueName);
        if(isCatalogueName < 1){
            return new ObjectResult(CommonCode.FAIL,"目录名称不存在");
        }
        return new ObjectResult(CommonCode.SUCCESS,"目录名称存在");
    }

    /**
     * 按id修改指定目录信息
     * @param guliCatalogue
     * @return
     */
    @PutMapping("/updateCatalogue")
    public ObjectResult updateCatalogue(@RequestBody GuliCatalogue guliCatalogue){
        int i = guliCatalogueService.updateCatalogue(guliCatalogue);
        if(i < 1){
            return new ObjectResult(CommonCode.FAIL,"修改失败");
        }
        return new ObjectResult(CommonCode.SUCCESS,"修改成功");
    }

    /**
     * 按条件分页查询目录信息
     * @param pageNo 当前页
     * @param pageSize 数据量
     * @param courseId 课程id
     * @param catalogueName 目录名称
     * @return
     */
    @GetMapping("/findAllPageCatalogue")
    public ObjectResult findAllPageCatalogue(@RequestParam("pageNo") int pageNo,
                                                                @RequestParam("pageSize")  int pageSize,
                                                                @RequestParam("courseId")  Long courseId,
                                                                @RequestParam("catalogueName")  String catalogueName){
        if(catalogueName.equals("")){
            catalogueName = "*";
        }
        return new ObjectResult(CommonCode.SUCCESS,guliCatalogueService.findAllPageCatalogue(pageNo,pageSize,courseId,catalogueName));
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
//    @GetMapping("/findAllPageCatalogue")
//    public ObjectResult findAllPageCatalogue(@RequestParam("pageNo") int pageNo,
//                                                                    @RequestParam("pageSize") int pageSize,
//                                                                    @RequestParam("userId") Long userId,
//                                                                    @RequestParam("courseId") Long courseId,
//                                                                    @RequestParam("catalogueName") String catalogueName){
//        GuliPower userIdPower = guliPowerService.findUserIdPower(userId);
//        if(userIdPower.getPowerName().equals("管理员")){
//            userId = -1l;
//        }
//        return new ObjectResult(CommonCode.SUCCESS, guliCatalogueService.findAllPageCatalogue(pageNo,pageSize,userId,courseId,catalogueName));
//    }

}
