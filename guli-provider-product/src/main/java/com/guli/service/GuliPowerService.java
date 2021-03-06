package com.guli.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.pojo.GuliPower;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * ?û?Ȩ? 服务类
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
public interface GuliPowerService extends IService<GuliPower> {

    List<GuliPower> findPageGuliPower(Page<GuliPower> page, String powerName);

    int updatePower(GuliPower guliPower);
}
