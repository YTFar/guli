package com.guli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guli.pojo.GuliUser;
import com.guli.mapper.GuliUserMapper;
import com.guli.service.GuliUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ?û?? 服务实现类
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@Service
public class GuliUserServiceImpl extends ServiceImpl<GuliUserMapper, GuliUser> implements GuliUserService {

//    private GuliUserService guliUserService;
//
//    @Override
//    public GuliUser login(QueryWrapper<GuliUser> queryWrapper) {
//        return guliUserService.login(queryWrapper);
//    }
}
