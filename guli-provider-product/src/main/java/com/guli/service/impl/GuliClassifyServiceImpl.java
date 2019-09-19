package com.guli.service.impl;

import com.guli.pojo.GuliClassify;
import com.guli.mapper.GuliClassifyMapper;
import com.guli.pojo.classifyvo.classifyNode;
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
    public List<classifyNode> findAllClassifyNode() {
        return this.baseMapper.findAllClassifyNode();
    }

    @Override
    @Transactional
    public int addClassify(GuliClassify guliClassify) {
        return this.baseMapper.insert(guliClassify);
    }
}
