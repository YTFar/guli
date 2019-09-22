package com.guli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.pojo.GuliCatalogue;
import com.guli.mapper.GuliCatalogueMapper;
import com.guli.pojo.cataloguevo.CatalogueAndAccomplish;
import com.guli.pojo.cataloguevo.CatalogueAndCourse;
import com.guli.pojo.response.AllTypePage;
import com.guli.service.GuliCatalogueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.context.ThemeSource;

import java.util.List;

/**
 * <p>
 * ?γ?Ŀ¼? 服务实现类
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@Service
public class GuliCatalogueServiceImpl extends ServiceImpl<GuliCatalogueMapper, GuliCatalogue> implements GuliCatalogueService {

    @Override
    @Transactional
    public int addCatalogue(GuliCatalogue guliCatalogue) {
        return this.baseMapper.insert(guliCatalogue);
    }

    @Override
    @Transactional
    public int updateCatalogue(GuliCatalogue guliCatalogue) {
        GuliCatalogue catalogue_id = this.baseMapper.selectOne(new QueryWrapper<GuliCatalogue>().eq("catalogue_id", guliCatalogue.getCatalogueId()));
        if(guliCatalogue.getCatalogueName()!=null)
            catalogue_id.setCatalogueName(guliCatalogue.getCatalogueName());
        return this.baseMapper.updateById(catalogue_id);
    }

    @Override
    public List<CatalogueAndCourse> findAllPageCatalogue(Page<CatalogueAndCourse> page, Long courseId, String catalogueName) {
        return this.baseMapper.findAllPageCatalogue(page,courseId,catalogueName);
    }


//    @Override
//    public List<CatalogueAndAccomplish> findAllPageCatalogue(Page<CatalogueAndAccomplish> page,Long userId, Long courseId, String catalogueName) {
//        return this.baseMapper.findAllPageCatalogue(page ,userId , courseId,catalogueName);
//    }
}
