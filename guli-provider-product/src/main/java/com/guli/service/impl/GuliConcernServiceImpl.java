package com.guli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guli.mapper.GuliConcernMapper;
import com.guli.pojo.GuliConcern;
import com.guli.pojo.concernvo.ConcernAndUser;
import com.guli.service.GuliConcernService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * ??˿? 服务实现类
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@Service
public class GuliConcernServiceImpl extends ServiceImpl<GuliConcernMapper, GuliConcern> implements GuliConcernService {

    @Override
    public List<ConcernAndUser> findPageConcern(Page<ConcernAndUser> page, int userId, String userName) {
        return this.baseMapper.findPageConcern(page,userId,userName);
    }

    @Override
    public List<ConcernAndUser> findPageTowConcern(Page<ConcernAndUser> page, int userId, String userName) {
        return this.baseMapper.findPageTowConcern(page,userId,userName);
    }

    @Override
    public int deleteConcern(int concernId) {
        return this.baseMapper.delete(new QueryWrapper<GuliConcern>().eq("concern_id",concernId));
    }

}
