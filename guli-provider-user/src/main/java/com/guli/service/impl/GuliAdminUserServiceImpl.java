package com.guli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guli.mapper.GuliAdminUserMapper;
import com.guli.pojo.GuliUser;
import com.guli.service.GuliAdminUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * ?û?? 服务实现类
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
@Service
public class GuliAdminUserServiceImpl extends ServiceImpl<GuliAdminUserMapper, GuliUser> implements GuliAdminUserService {

    @Override
    public List<GuliUser> findMemberPage(Page<GuliUser> page, int userId, String userName) {
        return this.baseMapper.findMemberPage(page,userId,userName);
    }

    @Override
    @Transactional
    public int updateUser(GuliUser guliUser) {
        GuliUser user_id = this.baseMapper.selectOne(new QueryWrapper<GuliUser>().eq("user_id", guliUser.getUserId()));
        if(guliUser.getUserPhone() != null)
            user_id.setUserPhone(guliUser.getUserPhone());
        if(guliUser.getUserEmail() != null)
            user_id.setUserEmail(guliUser.getUserPhone());
        if(guliUser.getUserIamge() != null)
            user_id.setUserIamge(guliUser.getUserIamge());
        if(guliUser.getUserRealName() != null)
            user_id.setUserRealName(guliUser.getUserRealName());
        if(guliUser.getUserSex() != null)
            user_id.setUserSex(guliUser.getUserSex());
        if (guliUser.getUserBrief() != null)
            user_id.setUserBrief(guliUser.getUserBrief());
        if(guliUser.getUserIntroduce() != null)
            user_id.setUserIntroduce(guliUser.getUserIntroduce());
        if(guliUser.getUserCompany() != null)
            user_id.setUserCompany(guliUser.getUserCompany());
        if(guliUser.getUserMicroblog() != null)
            user_id.setUserMicroblog(guliUser.getUserMicroblog());
        if(guliUser.getUserWechat() != null)
            user_id.setUserWechat(guliUser.getUserWechat());
        if(guliUser.getUserQq() != null)
            user_id.setUserQq(guliUser.getUserQq());
        return this.baseMapper.updateById(user_id);
    }

//    private GuliUserService guliUserService;
//
//    @Override
//    public GuliUser login(QueryWrapper<GuliUser> queryWrapper) {
//        return guliUserService.login(queryWrapper);
//    }
}
