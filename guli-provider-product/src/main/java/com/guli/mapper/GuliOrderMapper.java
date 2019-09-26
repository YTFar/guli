package com.guli.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.pojo.GuliOrder;
import com.guli.pojo.ordervo.OrderAndUser;
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
            "<if test=\"userId != null and userId != -1\">",
            "a.order_id in (select order_id from guli_order where item_id in (select item_id from guli_item where user_id = #{userId}))",
            "</if>",
            "<if test=\"orderNumber != null and orderNumber !=''\">",
            "AND order_number = #{orderNumber}",
            "</if>",
            "<if test=\"userId != null and userId != ''\">",
            "AND user_name like concat('%',#{userName},'%')",
            "</if>",
            "<if test=\"orderStatus != null and orderStatus != -1\">",
            "AND order_status = #{orderStatus}",
            "</if>",
            "</trim>",
            "ORDER BY order_id DESC",
            "</script>"})
    List<OrderAndUser> findAllPageOrdel(Page<OrderAndUser> page,
                                        @Param("userId") Long userId,
                                        @Param("orderNumber") String orderNumber,
                                        @Param("userName") String userName,
                                        @Param("orderStatus") int orderStatus);

    @Select({"<script>",
            "select a.*,b.user_name,b.user_email,b.user_phone,d.user_id as shipperId,d.user_name as shipper from guli_order a",
            "INNER JOIN guli_user b on a.user_id = b.user_id",
            "INNER JOIN guli_item c ON a.item_id = c.item_id",
            "INNER JOIN guli_user d ON c.user_id = d.user_id",
            "WHERE a.order_id = #{orderId}",
            "</script>"})
    OrderAndUser findOneOrder(int orderId);

//    @Select(" select * from guli_order a INNER JOIN guli_user b on a.user_id = b.user_id where a.order_id in (select order_id from guli_order where item_id in (select item_id from guli_item where user_id = #{userId}))")
//    List<OrderAndUser> findAllOrdel(int userId);
}
