package com.guli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.pojo.GuliPower;
import com.guli.mapper.GuliPowerMapper;
import com.guli.service.GuliPowerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * ?û?Ȩ? 服务实现类
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@Service
public class GuliPowerServiceImpl extends ServiceImpl<GuliPowerMapper, GuliPower> implements GuliPowerService {

    @Override
    public List<GuliPower> findPageGuliPower(Page<GuliPower> page, String powerName) {
        return this.baseMapper.findPageGuliPower(page,powerName);
    }

    @Override
    @Transactional
    public int updatePower(GuliPower guliPower) {
        GuliPower power_id = this.baseMapper.selectOne(new QueryWrapper<GuliPower>().eq("power_id", guliPower.getPowerId()));
        if(guliPower.getPowerName() != null)
            power_id.setPowerName(guliPower.getPowerName());
        return this.baseMapper.updateById(power_id);
    }
}
