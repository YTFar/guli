package com.guli.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.pojo.GuliPower;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * ?û?Ȩ? Mapper 接口
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
public interface GuliPowerMapper extends BaseMapper<GuliPower> {

    @Select({"<script>",
            "SELECT a.*,b.user_name,b.user_phone,user_email FROM guli_power a",
            "INNER JOIN guli_user b ON a.user_id = b.user_id",
            "<trim prefix=\"where\" prefixOverrides=\"and||or\">",
            "<if test=\"powerName != null and powerName != ''\">",
            "AND a.power_name = #{powerName}",
            "</if>",
            "</trim>",
            "ORDER BY power_id DESC",
            "</script>"})
    List<GuliPower> findPageGuliPower(Page<GuliPower> page, @Param("powerName") String powerName);
}
