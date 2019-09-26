package com.guli.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.pojo.GuliUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * ?û?? Mapper 接口
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
public interface GuliAdminUserMapper extends BaseMapper<GuliUser> {

    @Select({"<script>",
            "SELECT a.* FROM guli_user a ",
            "INNER JOIN guli_item b ON a.user_id = b.user_id",
            "<trim prefix=\"where\" prefixOverrides=\"and||or\">",
            "b.course_affiliate = 1",
            "<if test=\"userId != null and userId != -1\">",
            "AND course_id IN (SELECT course_id FROM guli_item WHERE user_id = #{userId})",
            "</if>",
            "<if test=\"userName != null and userName != ''\">",
            "AND user_name like concat('%',#{userName},'%')",
            "</if>",
            "</trim>",
            "Group By a.user_id Having Count(0)>1",
            "ORDER BY user_id DESC",
            "</script>"})
    List<GuliUser> findMemberPage(Page<GuliUser> page, @Param("userId") int userId, @Param("userName") String userName);
}
