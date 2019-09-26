package com.guli.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.pojo.GuliConcern;
import com.guli.pojo.concernvo.ConcernAndUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * ??˿? Mapper 接口
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
public interface GuliConcernMapper extends BaseMapper<GuliConcern> {

    @Select({"<script>",
            "SELECT a.*,b.user_name  as beFocusedName,c.user_phone,c.user_email,c.user_name FROM guli_concern a",
            "INNER JOIN guli_user b ON a.user_id = b.user_id",
            "INNER JOIN guli_user c ON a.fans_id = c.user_id",
            "<trim prefix=\"where\" prefixOverrides=\"and||or\">",
            "<if test=\"userId != null and userId != -1\">",
            "AND a.user_id = #{userId}",
            "</if>",
            "<if test=\"userName != null and userName != ''\">",
            "AND c.user_name like concat('%',#{userName},'%')",
            "</if>",
            "</trim>",
            "ORDER BY concern_id DESC",
            "</script>"})
    List<ConcernAndUser> findPageConcern(Page<ConcernAndUser> page, @Param("userId") int userId, @Param("userName") String userName);

    @Select({"<script>",
            "SELECT a.*,b.user_name,b.user_phone,b.user_email,c.user_name as attentionName FROM guli_concern a",
            "INNER JOIN guli_user b ON a.user_id = b.user_id",
            "INNER JOIN guli_user c ON a.fans_id = c.user_id",
            "<trim prefix=\"where\" prefixOverrides=\"and||or\">",
            "<if test=\"userId != null and userId != -1\">",
            "AND a.fans_id = #{userId}",
            "</if>",
            "<if test=\"userName != null and userName != ''\">",
            "AND c.user_name like concat('%',#{userName},'%')",
            "</if>",
            "</trim>",
            "ORDER BY concern_id DESC",
            "</script>"})
    List<ConcernAndUser> findPageTowConcern(Page<ConcernAndUser> page,
                                            @Param("userId") int userId,
                                            @Param("userName") String userName);
}
