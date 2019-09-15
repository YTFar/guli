package com.guli.service.impl;

import com.guli.pojo.GuliActivitie;
import com.guli.mapper.GuliActivitieMapper;
import com.guli.service.GuliActivitieService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * ?? 服务实现类
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@Service
@Transactional
public class GuliActivitieServiceImpl extends ServiceImpl<GuliActivitieMapper, GuliActivitie> implements GuliActivitieService {

    @Override
    @Transactional
    public int addActivitie(GuliActivitie guliActivitie) {
        return this.baseMapper.insert(guliActivitie);
    }
}
