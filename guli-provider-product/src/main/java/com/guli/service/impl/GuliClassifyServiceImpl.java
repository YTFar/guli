package com.guli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guli.pojo.GuliClassify;
import com.guli.mapper.GuliClassifyMapper;
import com.guli.pojo.classifyvo.ClassifyNode;
import com.guli.service.GuliClassifyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * ????? 服务实现类
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@Service
public class GuliClassifyServiceImpl extends ServiceImpl<GuliClassifyMapper, GuliClassify> implements GuliClassifyService {

    @Override
    public List<ClassifyNode> findAllClassifyNode() {
        return this.baseMapper.findAllClassifyNode();
    }

    @Override
    @Transactional
    public int addClassify(GuliClassify guliClassify) {
        return this.baseMapper.insert(guliClassify);
    }

    @Override
    public int updateClassify(GuliClassify guliClassify) {
        GuliClassify classify_id = this.baseMapper.selectOne(new QueryWrapper<GuliClassify>().eq("classify_id", guliClassify.getClassifyId()));
        if (guliClassify.getClassifyName() != null)
            classify_id.setClassifyName(guliClassify.getClassifyName());
        if(guliClassify.getParentId() != null)
            classify_id.setParentId(guliClassify.getParentId());
        return this.baseMapper.updateById(classify_id);
    }
}
