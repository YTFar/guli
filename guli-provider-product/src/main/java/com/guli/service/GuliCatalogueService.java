package com.guli.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.pojo.GuliCatalogue;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guli.pojo.cataloguevo.CatalogueAndAccomplish;
import com.guli.pojo.cataloguevo.CatalogueAndCourse;
import com.guli.pojo.response.AllTypePage;

import java.util.List;

/**
 * <p>
 * ?γ?Ŀ¼? 服务类
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
public interface GuliCatalogueService extends IService<GuliCatalogue> {

    int addCatalogue(GuliCatalogue guliCatalogue);

    int updateCatalogue(GuliCatalogue guliCatalogue);

//    AllTypePage<CatalogueAndCourse> findAllPageCatalogue(int pageNo, int pageSize, Long courseId, String catalogueName);

    List<CatalogueAndCourse> findAllPageCatalogue(Page<CatalogueAndCourse> page, Long courseId, String catalogueName);

//    List<CatalogueAndAccomplish> findAllPageCatalogue(Page<CatalogueAndAccomplish> page,Long userId, Long courseId, String catalogueName);
}
