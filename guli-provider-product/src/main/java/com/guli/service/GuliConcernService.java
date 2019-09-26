package com.guli.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guli.pojo.GuliConcern;
import com.guli.pojo.concernvo.ConcernAndUser;

import java.util.List;

/**
 * <p>
 * ??˿? 服务类
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
public interface GuliConcernService extends IService<GuliConcern> {

    List<ConcernAndUser> findPageConcern(Page<ConcernAndUser> page, int userId, String userName);

    List<ConcernAndUser> findPageTowConcern(Page<ConcernAndUser> page, int userId, String userName);

    int deleteConcern(int concernId);
}
