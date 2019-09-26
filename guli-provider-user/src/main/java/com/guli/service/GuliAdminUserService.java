package com.guli.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guli.pojo.GuliUser;

import java.util.List;

/**
 * <p>
 * ?û?? 服务类
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
public interface GuliAdminUserService extends IService<GuliUser> {


    List<GuliUser> findMemberPage(Page<GuliUser> page, int userId, String userName);

    int updateUser(GuliUser guliUser);
}
