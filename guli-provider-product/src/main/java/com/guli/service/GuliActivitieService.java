package com.guli.service;

import com.guli.pojo.GuliActivitie;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * ?? 服务类
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
public interface GuliActivitieService extends IService<GuliActivitie> {

    int addActivitie(GuliActivitie guliActivitie);
}
