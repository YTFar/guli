package com.guli.mapper;

import com.guli.pojo.GuliOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guli.pojo.OrderVo.GuliOrderAndUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * ????? Mapper 接口
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
public interface GuliOrderMapper extends BaseMapper<GuliOrder> {

    @Select(" select * from guli_order a INNER JOIN guli_user b on a.user_id = b.user_id where a.order_id in (select order_id from guli_order where item_id in (select item_id from guli_item where user_id = #{userId}))")
    List<GuliOrderAndUser> findAllOrdel(int userId);
}
