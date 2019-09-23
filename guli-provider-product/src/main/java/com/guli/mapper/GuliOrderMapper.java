package com.guli.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.pojo.GuliOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guli.pojo.OrderVo.OrderAndUser;
import org.apache.ibatis.annotations.Param;
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

    @Select({"<script>",
            "select * from guli_order a",
            "INNER JOIN guli_user b on a.user_id = b.user_id",
            "<trim prefix=\"where\" prefixOverrides=\"and||or\">",
//            "<if test=\"userId != null and userId != -1\">",
//            "a.order_id in (select order_id from guli_order where item_id in (select item_id from guli_item where user_id = #{userId}))",
//            "</if>",
            "<if test=\"orderNumber != null and orderNumber !='' \">",
            "AND order_number = #{orderNumber}",
            "</if>",
            "<if test=\"userName != null and userName != ''\">",
            "AND user_name like concat('%',#{userName},'%')",
            "</if>",
            "</trim>",
            "ORDER BY order_id DESC",
            "</script>"})
    List<OrderAndUser> findAllPageOrdel(Page<OrderAndUser> page, @Param("userId") int userId,
                                        @Param("orderNumber") String orderNumber,@Param("userName") String userName);

//    @Select(" select * from guli_order a INNER JOIN guli_user b on a.user_id = b.user_id where a.order_id in (select order_id from guli_order where item_id in (select item_id from guli_item where user_id = #{userId}))")
//    List<OrderAndUser> findAllOrdel(int userId);
}
